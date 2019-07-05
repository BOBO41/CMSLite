package com.xiang.utils;

import org.apache.commons.lang3.StringUtils;

public class Handle {
	public static boolean vaildateFile(String path) {
		String temp=path;
		if(StringUtils.isEmpty(path)) {
			return false;
		}
		temp=temp.toLowerCase();
		//linux不允许使用向上路径,有可能导致文件攻击
		if(temp.contains("..")) {
			return false;
		}
		return true;
	}

}
