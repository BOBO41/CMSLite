package com.xiang.translate;

import java.util.Map;

public class ObjectPolicy {
	private Map<String, PolicyNode> searchs;
	private Map<String, PolicyNode> texts;
	private Map<String, PolicyNode> fields;
	public Map<String, PolicyNode> getSearchs() {
		return searchs;
	}
	public void setSearchs(Map<String, PolicyNode> searchs) {
		this.searchs = searchs;
	}
	public Map<String, PolicyNode> getTexts() {
		return texts;
	}
	public void setTexts(Map<String, PolicyNode> texts) {
		this.texts = texts;
	}
	public Map<String, PolicyNode> getFields() {
		return fields;
	}
	public void setFields(Map<String, PolicyNode> fields) {
		this.fields = fields;
	}
	
	
	
}
