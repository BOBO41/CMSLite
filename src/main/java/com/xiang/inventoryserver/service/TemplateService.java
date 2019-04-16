package com.xiang.inventoryserver.service;

import java.util.Map;

public interface TemplateService {
	public String getTemplate(String name,Map<String, Object> dataModel);
}
