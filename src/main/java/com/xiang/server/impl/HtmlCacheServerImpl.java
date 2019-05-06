package com.xiang.server.impl;

import java.util.Locale;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.util.ObjectUtils;

import com.xiang.server.CacheNameSpace;
import com.xiang.server.CacheServer;
import com.xiang.server.HtmlCacheServer;

/**
 * @author xiang
 * @createDate 2019年05月02日 下午2:18:51
 */
public class HtmlCacheServerImpl implements HtmlCacheServer {
	 CacheServer cacheServer;
	public CacheServer getCacheServer() {
		return cacheServer;
	}
	public void setCacheServer(CacheServer cacheServer) {
		this.cacheServer = cacheServer;
	}
	private PatternMatcher pathMatcher = new AntPathMatcher();
	private boolean cache=false;
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	private String[] mapping;
	public String[] getMapping() {
		return mapping;
	}
	public void setMapping(String[] mapping) {
		this.mapping = mapping;
	}
	private String getKey(Locale locale,String key) {
		if(locale!=null) {
			return CacheNameSpace.HTMLNAMESPACE+locale.toString()+key;
		}
		return CacheNameSpace.HTMLNAMESPACE+key;
	}
	
	private boolean isMatch(String url) {
		if(cache && !ObjectUtils.isEmpty(mapping)) {
			for(String pattern:mapping) {
				boolean isMatch = pathMatcher.matches(pattern, url);
				if(isMatch) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public void clear(Locale locale, String url) {
		cacheServer.clear(getKey(locale,url));
	}
	@Override
	public void clearAll() {
		cacheServer.clearAll(CacheNameSpace.HTMLNAMESPACE);
	}
	@Override
	public Object getCache(Locale locale, String url) {
		if(isMatch(url)) {
			return cacheServer.getCache(getKey(locale,url));
		}
		return null;
	}
	@Override
	public void setCache(Locale locale,String url, Object data,long seconds) {
				if(isMatch(url)) {
					cacheServer.setCache(getKey(locale,url),data,seconds);
				}
	}
	@Override
	public void setCache(Locale locale, String url, Object data) {
		setCache(locale,url,data,0);
	}
}
