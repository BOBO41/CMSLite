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

}
