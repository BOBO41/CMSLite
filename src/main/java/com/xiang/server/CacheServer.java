package com.xiang.server;

public interface CacheServer{
	public void setCache(String key,Object data);
	public void setCache(String key,Object data,long seconds);
	public Object getCache(String key);
	public void clear(String key);
	public void clearAll(String namespace);
	public void clearAll();
}
