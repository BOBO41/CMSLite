package com.xiang.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.robert.vesta.service.intf.IdService;
import com.xiang.bean.po.TranslateField;
import com.xiang.mapper.TranslateFieldMapper;
import com.xiang.server.SystemConfig;
import com.xiang.service.TranslateService;
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
	SystemConfig systemConfig;
	private Map<String, LinkedList<PolicyNode>> poLicyCache = new ConcurrentHashMap<>();

	@Override
	public void save(Object po, Long refererId, String language){
		if (systemConfig.isDefaultLocale(language)) {
			// 默认语言无需添加记录
			return;
		}
		LinkedList<PolicyNode> list = null;
		String cacheKey = po.getClass().getName();
		if (!poLicyCache.containsKey(cacheKey)) {
			Field[] fields = po.getClass().getDeclaredFields();
			list = new LinkedList<>();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Translate.class)) {
					Translate translate = field.getAnnotation(Translate.class);
					TranslatePolicy policy = translate.policy();
					PolicyNode node = new PolicyNode(policy, field);
					list.add(node);
				}
			}
			poLicyCache.put(cacheKey, list);
		} else {
			list = poLicyCache.get(cacheKey);
		}
		if (!ObjectUtils.isEmpty(list)) {
			JSONObject jsonObject = new JSONObject();
			for (PolicyNode node : list) {
				Object value=null;
				try {
					value = node.getField().get(po);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (value != null) {
					switch (node.getPolicy()) {
					case FIELD:
						jsonObject.put(node.getField().getName(), value);
						break;
					case SEARCH:
						break;
					case TEXT:
						break;
					}
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
	}

}
