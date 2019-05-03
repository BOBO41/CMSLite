package com.xiang.server;

/**
 * 缓存的命名空间
 * 使用不同的命名空间来划分不同业务，让清除缓存更清晰,所有的业务缓存必须头带上对应的命名空间
 * @author xiang
 *
 */
public class CacheNameSpace {
	public static final String HTMLNAMESPACE="html_";
}
