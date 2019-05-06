package com.xiang.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.po.TranslateField;
import com.xiang.bean.po.TranslateFieldExample;
import com.xiang.bean.po.TranslateSearch;
import com.xiang.bean.po.TranslateSearchExample;
import com.xiang.bean.po.TranslateText;
import com.xiang.bean.po.TranslateTextExample;
import com.xiang.mapper.TranslateFieldMapper;
import com.xiang.mapper.TranslateSearchMapper;
import com.xiang.mapper.TranslateTextMapper;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.server.SystemConfig;
import com.xiang.service.TranslateService;
import com.xiang.translate.ObjectPolicy;
import com.xiang.translate.PolicyNode;
import com.xiang.translate.Translate;
import com.xiang.translate.TranslatePolicy;

@Service("translateService")
public class TranslateServiceImpl implements TranslateService {
	@Resource
	private IdService idService;
	@Autowired
	private TranslateFieldMapper translateFieldMapper;
	@Autowired
	private TranslateSearchMapper translateSearchMapper;
	@Autowired
	private TranslateTextMapper translateTextMapper;
	@Autowired
	SystemConfig systemConfig;
	private final static String IDFIELD = "id";

	private Map<String, ObjectPolicy> poLiciesCache = new ConcurrentHashMap<>();

	private Map<String, Field> idFieldCache = new ConcurrentHashMap<>();

	private TranslateField getTranslateField(Long refererId, String type, String language) {
		List<Long> refererIds=new ArrayList<Long>(1);
		refererIds.add(refererId);
		List<TranslateField> result =getTranslateFields(refererIds,type,language);
		if (!ObjectUtils.isEmpty(result)) {
			return result.get(0);
		}
		return null;
	}
	private List<TranslateField> getTranslateFields(List<Long> refererIds, String type, String language) {
		TranslateFieldExample example = new TranslateFieldExample();
		PageHelper.offsetPage(0, 1);
		example.createCriteria().andRefererIdIn(refererIds).andTypeEqualTo(type).andLanguageEqualTo(language);
		return translateFieldMapper.selectByExample(example);
	}

	private List<TranslateText> getTranslateText(Long refererId, List<String> fields, String type, String language) {
		List<Long> refererIds=new ArrayList<Long>(1);
		refererIds.add(refererId);
		return getTranslateTexts(refererIds,fields,type,language);
	}
	private List<TranslateText> getTranslateTexts(List<Long> refererIds, List<String> fields, String type, String language) {
		TranslateTextExample example = new TranslateTextExample();
		example.createCriteria().andRefererIdIn(refererIds).andFieldIn(fields).andTypeEqualTo(type)
				.andLanguageEqualTo(language);
		return translateTextMapper.selectByExample(example);
	}

	private List<TranslateSearch> getTranslateSearch(Long refererId, List<String> fields, String type, String language) {
		List<Long> refererIds=new ArrayList<Long>(1);
		refererIds.add(refererId);
		return getTranslateSearchs(refererIds,fields,type,language);
	}
	private List<TranslateSearch> getTranslateSearchs(List<Long> refererIds, List<String> fields, String type, String language) {
		TranslateSearchExample example = new TranslateSearchExample();
		example.createCriteria().andRefererIdIn(refererIds).andFieldIn(fields).andTypeEqualTo(type)
				.andLanguageEqualTo(language);
		return translateSearchMapper.selectByExample(example);
	}

	private ObjectPolicy getPolicies(String cacheKey, Object po) {
		ObjectPolicy objectPolicy = poLiciesCache.get(cacheKey);
		if (objectPolicy != null)
			return objectPolicy;

		Field[] fields = po.getClass().getDeclaredFields();
		Map<String, PolicyNode> searchMap = new HashMap<>();
		Map<String, PolicyNode> textMap = new HashMap<>();
		Map<String, PolicyNode> fieldMap = new HashMap<>();
		for (Field field : fields) {
			if (IDFIELD.equals(field.getName())) {
				field.setAccessible(true);
				idFieldCache.put(cacheKey, field);
			}
			if (field.isAnnotationPresent(Translate.class)) {
				Translate translate = field.getAnnotation(Translate.class);
				TranslatePolicy policy = translate.policy();
				field.setAccessible(true);
				PolicyNode node = new PolicyNode(cacheKey, policy, field);
				switch (translate.policy()) {
				case FIELD:
					fieldMap.put(field.getName(), node);
					break;
				case TEXT:
					textMap.put(field.getName(), node);
					break;
				case SEARCH:
					searchMap.put(field.getName(), node);
					break;
				}
			}
		}
		objectPolicy = new ObjectPolicy();
		objectPolicy.setFields(fieldMap);
		objectPolicy.setTexts(textMap);
		objectPolicy.setSearchs(searchMap);
		poLiciesCache.put(cacheKey, objectPolicy);
		return objectPolicy;
	}

	private String getUniqueKey(TranslateSearch record) {
		return record.getRefererId().toString() + record.getField() + record.getType() + record.getLanguage();
	}

	private String getUniqueKey(TranslateText record) {
		return record.getRefererId().toString() + record.getField() + record.getType() + record.getLanguage();
	}

	private Long getRefererId(String cacheKey, Object po) {
		Field idField = idFieldCache.get(cacheKey);
		Long refererId = null;
		try {
			refererId = (Long) idField.get(po);
		} catch (Exception e) {
			e.printStackTrace();
			throw new APIException(ErrorCodes.TRANSALE_ERROR);
		}
		if (refererId == null) {
			throw new APIException(ErrorCodes.TRANSALE_ERROR);
		}
		return refererId;
	}

	@Override
	public void save(Object po, String language) {
		if (systemConfig.isDefaultLocale(language) || po == null) {
			// 默认语言无需添加记录
			return;
		}
		String cacheKey = po.getClass().getSimpleName();
		ObjectPolicy objectPolicy = getPolicies(cacheKey, po);
		if (objectPolicy == null) {
			return;
		}
		Long refererId = getRefererId(cacheKey, po);
		// 保存FIELD类型国际化字段
		if (!objectPolicy.getFields().isEmpty()) {
			JSONObject jsonObject = new JSONObject();
			for (PolicyNode node : objectPolicy.getFields().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					jsonObject.put(node.getField().getName(), value);
				}
			}
			if (!jsonObject.isEmpty()) {
				long id = idService.genId();
				TranslateField record = new TranslateField();
				record.setAddTime(new Date());
				record.setContent(jsonObject.toJSONString());
				record.setDel(false);
				record.setId(id);
				record.setLanguage(language);
				record.setRefererId(refererId);
				record.setType(cacheKey);
				translateFieldMapper.save(record);
			}
		}

		// 保存TEXT类型国际化字段
		if (!objectPolicy.getTexts().isEmpty()) {
			for (PolicyNode node : objectPolicy.getTexts().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					long id = idService.genId();
					TranslateText record = new TranslateText();
					record.setAddTime(new Date());
					record.setDel(false);
					record.setId(id);
					record.setField(node.getField().getName());
					record.setContent(value.toString());
					record.setLanguage(language);
					record.setRefererId(refererId);
					record.setType(cacheKey);
					translateTextMapper.save(record);
				}
			}
		}

		// 保存SEARCH类型国际化字段
		if (!objectPolicy.getSearchs().isEmpty()) {
			for (PolicyNode node : objectPolicy.getSearchs().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					long id = idService.genId();
					TranslateSearch record = new TranslateSearch();
					record.setAddTime(new Date());
					record.setDel(false);
					record.setId(id);
					record.setField(node.getField().getName());
					record.setContent(value.toString());
					record.setLanguage(language);
					record.setRefererId(refererId);
					record.setType(cacheKey);
					translateSearchMapper.save(record);
				}
			}
		}
	}

	/**
	 * 更新逻辑：SEARCH和TEXT类型的国际化，先查询要更新字段的国际化，如果没有的进行保存，如果存在的进行更新。
	 * FIELD类型的国际化，先查询要更新字段的国际化，如果没有的进行保存，如果存在就进行合并之后再更新。
	 * 
	 * @param po
	 * @param refererId
	 * @param language
	 */
	@Override
	public void update(Object po, String language) {
		if (systemConfig.isDefaultLocale(language) || po == null) {
			// 默认语言无需修改记录
			return;
		}
		String cacheKey = po.getClass().getSimpleName();
		ObjectPolicy objectPolicy = getPolicies(cacheKey, po);
		if (objectPolicy == null) {
			return;
		}
		Long refererId = getRefererId(cacheKey, po);

		// 更新FIELD类型国际化字段
		if (!objectPolicy.getFields().isEmpty()) {
			JSONObject jsonObject = null;
			// Field类型国际化，先查询数据库已有记录
			TranslateField translateField = getTranslateField(refererId, cacheKey, language);
			if (translateField != null) {
				String content = translateField.getContent();
				if (!ObjectUtils.isEmpty(content)) {
					jsonObject = JSONObject.parseObject(content);
				}
			}
			if (jsonObject == null) {
				jsonObject = new JSONObject();
			}
			for (PolicyNode node : objectPolicy.getFields().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
					node.getField().set(po, null);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					jsonObject.put(node.getField().getName(), value);
				}
			}

			if (!jsonObject.isEmpty()) {
				if (translateField == null) {
					// 不存在进行保存
					long id = idService.genId();
					TranslateField record = new TranslateField();
					record.setAddTime(new Date());
					record.setContent(jsonObject.toJSONString());
					record.setDel(false);
					record.setId(id);
					record.setLanguage(language);
					record.setRefererId(refererId);
					record.setType(cacheKey);
					translateFieldMapper.save(record);
				} else {
					// 存在进行更新
					translateField.setContent(jsonObject.toJSONString());
					translateFieldMapper.updateByPrimaryKeySelective(translateField);
				}
			}
		}
		// 更新SEARCH类型国际化字段
		if (!objectPolicy.getSearchs().isEmpty()) {
			List<String> searchList = new ArrayList<String>(objectPolicy.getSearchs().size());
			Map<String, TranslateSearch> updateSearchMap = new HashMap<>(objectPolicy.getSearchs().size());
			for (PolicyNode node : objectPolicy.getSearchs().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
					node.getField().set(po, null);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					TranslateSearch record = new TranslateSearch();
					record.setField(node.getField().getName());
					record.setContent(value.toString());
					record.setLanguage(language);
					record.setRefererId(refererId);
					record.setType(cacheKey);
					searchList.add(record.getField());
					updateSearchMap.put(getUniqueKey(record), record);
				}
			}
			if (!searchList.isEmpty()) {
				List<TranslateSearch> result = getTranslateSearch(refererId, searchList, cacheKey, language);
				if (result != null) {
					for (TranslateSearch translateSearch : result) {
						String key = getUniqueKey(translateSearch);
						TranslateSearch update = updateSearchMap.get(key);
						if (update != null) {
							update.setId(translateSearch.getId());
							translateSearchMapper.updateByPrimaryKeySelective(update);
							updateSearchMap.remove(key);
						}
					}
				}
				// 数据库没有的记录进行保存
				for (TranslateSearch record : updateSearchMap.values()) {
					long id = idService.genId();
					record.setAddTime(new Date());
					record.setDel(false);
					record.setId(id);
					translateSearchMapper.save(record);
				}
			}
		}
		// 需要更新TEXT类型国际化的字段
		if (!objectPolicy.getTexts().isEmpty()) {
			List<String> textList = new ArrayList<String>(objectPolicy.getTexts().size());
			Map<String, TranslateText> updateTextMap = new HashMap<>(objectPolicy.getTexts().size());
			for (PolicyNode node : objectPolicy.getTexts().values()) {
				Object value = null;
				try {
					value = node.getField().get(po);
					node.getField().set(po, null);
				} catch (Exception e) {
					e.printStackTrace();
					throw new APIException(ErrorCodes.TRANSALE_ERROR);
				}
				if (value != null) {
					TranslateText record = new TranslateText();
					record.setField(node.getField().getName());
					record.setContent(value.toString());
					record.setLanguage(language);
					record.setRefererId(refererId);
					record.setType(cacheKey);
					textList.add(record.getField());
					updateTextMap.put(getUniqueKey(record), record);
				}
			}
			if (!textList.isEmpty()) {
				List<TranslateText> result = getTranslateText(refererId, textList, cacheKey, language);
				if (result != null) {
					for (TranslateText translate : result) {
						String key = getUniqueKey(translate);
						TranslateText update = updateTextMap.get(key);
						if (update != null) {
							update.setId(translate.getId());
							translateTextMapper.updateByPrimaryKeySelective(update);
							updateTextMap.remove(key);// 移除已更新记录，剩余就是需要保存的记录
						}
					}
				}
				// 数据库没有的记录进行保存
				for (TranslateText record : updateTextMap.values()) {
					long id = idService.genId();
					record.setAddTime(new Date());
					record.setDel(false);
					record.setId(id);
					translateTextMapper.save(record);
				}
			}
		}
	}
	@Override
	public List translateList(List pos, String language) {
		if (systemConfig.isDefaultLocale(language) || ObjectUtils.isEmpty(pos)) {
			// 默认语言无需修改记录
			return pos;
		}
		Object po = pos.get(0);
		String cacheKey = po.getClass().getSimpleName();
		ObjectPolicy objectPolicy = getPolicies(cacheKey, po);
		if (objectPolicy == null) {
			return pos;
		}
		Map<Long,Object> posMap=new HashMap<>(pos.size());
		for (Object obj : pos) {
			Long refererId=getRefererId(cacheKey, obj);
			posMap.put(refererId, obj);
		}
		List<Long> refererIds=new ArrayList<Long>(posMap.keySet());
		Map<String, PolicyNode> searchMap = objectPolicy.getSearchs();
		Map<String, PolicyNode> textMap = objectPolicy.getTexts();
		Map<String, PolicyNode> fieldMap = objectPolicy.getFields();
		if (!fieldMap.isEmpty()) {
			List<TranslateField> translateFields = getTranslateFields(refererIds, cacheKey, language);//注意此处如果查询id多的时候，注意是否会超出mysql单次查询size
			if (translateFields != null) {
				for(TranslateField translateField:translateFields) {
				String content = translateField.getContent();
				if (!ObjectUtils.isEmpty(content)) {
					JSONObject jsonObject = JSONObject.parseObject(content);
					for (String key : jsonObject.keySet()) {
						PolicyNode node = fieldMap.get(key);
						if (node != null) {
							Object value = jsonObject.get(key);
							try {
								node.getField().set(posMap.get(translateField.getRefererId()), value);
							} catch (Exception e) {
								e.printStackTrace();
								throw new APIException(ErrorCodes.TRANSALE_ERROR);
							}
						}
					}
				}
				}
			}
		}

		if (!textMap.isEmpty()) {
			Set<String> fields = textMap.keySet();
			List<TranslateText> result = getTranslateTexts(refererIds, new ArrayList<>(fields), cacheKey, language);//注意此处如果查询id多的时候，注意是否会超出mysql单次查询size
			if (result != null) {
				for (TranslateText translate : result) {
					PolicyNode node = textMap.get(translate.getField());
					if (node != null) {
						Object value = translate.getContent();
						try {
							node.getField().set(posMap.get(translate.getRefererId()), value);
						} catch (Exception e) {
							e.printStackTrace();
							throw new APIException(ErrorCodes.TRANSALE_ERROR);
						}
					}
				}
			}
		}

		if (!searchMap.isEmpty()) {
			Set<String> fields = searchMap.keySet();
			List<TranslateSearch> result = getTranslateSearchs(refererIds, new ArrayList<>(fields), cacheKey, language);//注意此处如果查询id多的时候，注意是否会超出mysql单次查询size
			if (result != null) {
				for (TranslateSearch translate : result) {
					PolicyNode node = textMap.get(translate.getField());
					if (node != null) {
						Object value = translate.getContent();
						try {
							node.getField().set(posMap.get(translate.getRefererId()), value);
						} catch (Exception e) {
							e.printStackTrace();
							throw new APIException(ErrorCodes.TRANSALE_ERROR);
						}
					}
				}
			}
		}
		return pos;
	}

	@Override
	public Object translate(Object po, String language) {
		if (systemConfig.isDefaultLocale(language) || po == null) {
			// 默认语言无需修改记录
			return po;
		}
		List<Object> pos=new ArrayList<>(1);
		pos.add(po);
		List result=translateList(pos,language);
		if(!ObjectUtils.isEmpty(result)) {
			return result.get(0);
		}
		return po;
	}
}
