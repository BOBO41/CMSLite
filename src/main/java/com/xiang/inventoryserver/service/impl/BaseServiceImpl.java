package com.xiang.inventoryserver.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.github.pagehelper.PageHelper;
import com.google.common.base.CaseFormat;
import com.xiang.bean.po.CriteriaIgnoreKey;
import com.xiang.inventoryserver.exmapper.ExBaseMapper;
import com.xiang.inventoryserver.service.BaseService;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;
import com.xiang.restserver.Page;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private ExBaseMapper exBaseMapper;

	@Override
	public void setDelById(String table, Long[] ids, Boolean del) {
		if (!ObjectUtils.isEmpty(ids) && !Objects.isNull(del)) {
			exBaseMapper.setDel(table, ids, del);
		}
	}

	@Override
	public Page getPage(Map<String, Object> querys) {
		if (!ObjectUtils.isEmpty(querys)) {
			if (querys.containsKey(Page.LIMIT) && !querys.containsKey(Page.PAGE)) {
				throw new APIException(ErrorCodes.ERROR_PARAM);
			}
			if (!querys.containsKey(Page.LIMIT) && querys.containsKey(Page.PAGE)) {
				throw new APIException(ErrorCodes.ERROR_PARAM);
			}
			Page page = new Page();
			if (querys.containsKey(Page.LIMIT)) {
				page.setLimit((int) querys.get(Page.LIMIT));
			}
			if (querys.containsKey(Page.PAGE)) {
				page.setPage((int)querys.get(Page.PAGE));
				page.setCursor(((int) querys.get(Page.PAGE) - 1) * page.getLimit());
			}
			if (querys.containsKey(Page.SORT)) {
				String sort = (String) querys.get(Page.SORT);
				String orderBy = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort.substring(1));
				if (sort.startsWith("-")) {
					page.setSort(orderBy + " " + Page.DESC);
				} else {
					page.setSort(orderBy + " " + Page.ASC);
				}
			}
			return page;
		}
		return null;
	}

	@Override
	public Long getCount(Map<String, Object> querys) {
		return null;
	}

	@Override
	public List<T> getList(Map<String, Object> querys) {
		return null;
	}

	@Override
	public void setCriteria(Object criteria, Map<String, Object> querys) {
		// value==null 代表无参数,js页面使用null赋值将为NULL，使用undefined将不会有key传上来
		try {
			for (Map.Entry<String, Object> entry : querys.entrySet()) {
				String key = entry.getKey();
				if (!CriteriaIgnoreKey.contains(key)) {
					Object value = entry.getValue();
					if (Objects.isNull(value) || value instanceof CharSequence || !ObjectUtils.isEmpty(value)) {
						if(key.endsWith("Like") && !ObjectUtils.isEmpty(value)) {
							value="%"+value+"%";
						}
						MethodUtils.invokeMethod(criteria, key, value);
					}
				}
			}
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new APIException(ErrorCodes.ERROR_PARAM);
		}
	}

	@Override
	public void setPage(Page page) {
		if(!Objects.isNull(page)) {
			if(!Objects.isNull(page.getSort())) {
				PageHelper.startPage(page.getPage(), page.getLimit(), page.getSort());
			}else {
				if(!Objects.isNull(page.getPage())) {
				PageHelper.startPage(page.getPage(), page.getLimit());
				}
			}
		}
		
	}

	@Override
	public void setFlag(String table, String field, Long[] ids, Object flag) {
		if (!ObjectUtils.isEmpty(ids) && !Objects.isNull(flag)) {
			exBaseMapper.setFlag(table, field,ids, flag);
		}
		
	}

	@Override
	public Long getMax(String table, String field) {
		// TODO Auto-generated method stub
		return exBaseMapper.getMax(table, field);
	}

}
