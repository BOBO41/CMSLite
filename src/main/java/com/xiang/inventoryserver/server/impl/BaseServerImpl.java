package com.xiang.inventoryserver.server.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xiang.inventoryserver.server.BaseServer;
import com.xiang.inventoryserver.service.BaseService;

public class BaseServerImpl implements BaseServer{
	@Resource
	private BaseService baseService;
	@Transactional
	@Override
	public void setDelById(String table, Long[] ids, Boolean del) {
		baseService.setDelById(table,ids, del);
	}
	@Override
	public void setFlag(String table, String field, Long[] ids, Object flag) {
		baseService.setFlag(table, field, ids, flag);
		
	}
	@Override
	public Long getMax(String table, String field) {
		// TODO Auto-generated method stub
		return baseService.getMax(table, field);
	}

}
