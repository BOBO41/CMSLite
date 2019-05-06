package com.xiang.service;

import com.xiang.bean.po.TranslateField;

public interface TranslateFieldService extends BaseService<TranslateField>{
	public TranslateField get(Long id);
	public void save(TranslateField record);
	public void update(TranslateField record);
}
