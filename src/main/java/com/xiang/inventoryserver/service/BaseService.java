package com.xiang.inventoryserver.service;

import java.util.List;
import java.util.Map;

import com.xiang.restserver.Page;

public interface BaseService<T> {
	public Page getPage(Map<String, Object> querys);
	public Long getCount(Map<String, Object> querys);
	public List<T> getList(Map<String, Object> querys);
	public void setDelById(String table,Long[] ids,Boolean del);
	public void setCriteria(Object criteria,Map<String, Object> querys);
}
