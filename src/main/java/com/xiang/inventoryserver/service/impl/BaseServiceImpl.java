package com.xiang.inventoryserver.service.impl;

import java.util.Map;

import org.springframework.util.ObjectUtils;

import com.google.common.base.CaseFormat;
import com.xiang.inventoryserver.service.BaseService;
import com.xiang.restserver.Page;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	
	@Override
	public Page getPage(Map<String, Object> querys) {
		if(!ObjectUtils.isEmpty(querys))
		{
			Page page=new Page();
			if(querys.containsKey(Page.LIMIT))
			{
				page.setLimit((int)querys.get(Page.LIMIT));
			}
			if(querys.containsKey(Page.PAGE))
			{
				page.setCursor(((int)querys.get(Page.PAGE)-1)*page.getLimit());
			}
			if(querys.containsKey(Page.SORT))
			{
				String sort=(String)querys.get(Page.SORT);
				String orderBy=CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,sort.substring(1));
				if(sort.startsWith("+"))
				{
					page.setSort(orderBy +" "+Page.DESC);
				}else
				{
					page.setSort(orderBy +" "+Page.ASC);
				}
			}
			return page;
		}
		return null;
	}

}
