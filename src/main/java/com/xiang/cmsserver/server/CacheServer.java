package com.xiang.cmsserver.server;

import java.util.Locale;

public interface CacheServer{
	public void setCache(Locale locale,String url,Object data);
	public Object getCache(Locale locale,String url);
	public void clear(Locale locale,String url);
	public void clearAll();
}
