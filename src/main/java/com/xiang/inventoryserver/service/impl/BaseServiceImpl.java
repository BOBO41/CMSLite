package com.xiang.inventoryserver.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.common.base.CaseFormat;
import com.xiang.inventoryserver.exmapper.ExBaseMapper;
import com.xiang.inventoryserver.service.BaseService;
import com.xiang.restserver.Page;
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{
	@Autowired
	private ExBaseMapper exBaseMapper;
	@Override
	public void setDelById(String table,Long[] ids, Boolean del) {
		if(!ObjectUtils.isEmpty(ids) && !Objects.isNull(del))
		{
			exBaseMapper.setDel(table, ids, del);
		}
	}
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
	@Override
	public Long getCount(Map<String, Object> querys) {
		return null;
	}
	@Override
	public List<T> getList(Map<String, Object> querys) {
		return null;
	}

}
