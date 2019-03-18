package com.xiang.inventoryserver.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.common.base.CaseFormat;
import com.xiang.bean.po.CatalogExample.Criteria;
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
				if (sort.startsWith("+")) {
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
				if (!Page.LIMIT.equals(key) && !Page.PAGE.equals(key) && !Page.SORT.equals(key)) {
					Object value = entry.getValue();
					if (Objects.isNull(value)) {
						MethodUtils.invokeMethod(criteria, key, value);
					} else if (value instanceof CharSequence) {
						MethodUtils.invokeMethod(criteria, key, value);
					} else if (!ObjectUtils.isEmpty(value)) {
						MethodUtils.invokeMethod(criteria, key, value);
					}
				}
			}
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new APIException(ErrorCodes.ERROR_PARAM);
		}
	}

}
