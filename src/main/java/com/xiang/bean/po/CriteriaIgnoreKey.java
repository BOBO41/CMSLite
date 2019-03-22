package com.xiang.bean.po;

import java.util.HashSet;
import java.util.Set;

import com.xiang.restserver.Page;

public class CriteriaIgnoreKey {
	public static String CATALOGNOTOP="CatalogNoTop";
	static Set<String> keys;
	static {
		keys=new HashSet<>();
		keys.add(Page.LIMIT);
		keys.add(Page.PAGE);
		keys.add(Page.SORT);
		keys.add(CATALOGNOTOP);
	}
	public static boolean contains(String key) {
		return keys.contains(key);
	}
}
