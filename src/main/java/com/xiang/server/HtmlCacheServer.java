package com.xiang.server;

import java.util.Locale;

public interface HtmlCacheServer{
	public void setCache(Locale locale,String url,Object html);
	public void setCache(Locale locale,String url,Object html,long seconds);
	public Object getCache(Locale locale,String url);
	public void clear(Locale locale,String url);
	public void clearAll();
}
