package com.xiang.service;

import java.util.List;

public interface TranslateService {
	public void save(Object po,String language);
	public Object update(Object po,String language);
	public Object translate(Object po, String language);
	public List translateList(List pos, String language);
}
