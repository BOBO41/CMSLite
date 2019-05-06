package com.xiang.translate;

import java.lang.reflect.Field;

public class PolicyNode {
	
	public PolicyNode(String name,TranslatePolicy policy, Field field) {
		this.name = name;
		this.policy = policy;
		this.field = field;
	}
	private String name;
	private TranslatePolicy policy;
	private Field field;
	public TranslatePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(TranslatePolicy policy) {
		this.policy = policy;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
