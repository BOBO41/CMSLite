package com.xiang.translate;

import java.lang.reflect.Field;

public class PolicyNode {
	
	public PolicyNode(TranslatePolicy policy, Field field) {
		this.policy = policy;
		this.field = field;
	}
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
	
}
