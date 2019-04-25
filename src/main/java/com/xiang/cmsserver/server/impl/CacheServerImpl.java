package com.xiang.cmsserver.server.impl;

import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.util.ObjectUtils;

import com.xiang.cmsserver.server.CacheServer;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
public class CacheServerImpl implements CacheServer {
	private final static String CACHENAME="pageCache";
	private PatternMatcher pathMatcher = new AntPathMatcher();
	private String[] mapping;
	public String[] getMapping() {
		return mapping;
	}
	public void setMapping(String[] mapping) {
		this.mapping = mapping;
	}
	@Override
	public void setCache(Locale locale,String url, Object data) {
		if(!ObjectUtils.isEmpty(mapping)) {
			for(String pattern:mapping) {
				boolean isMatch = pathMatcher.matches(pattern, url);
				if(isMatch) {
					CacheManager manager = CacheManager.getInstance();
					Cache cache = manager.getCache(CACHENAME);
					Element e = new Element(getKey( locale, url), data, false);
					cache.put(e);
					return;
				}
			}
		}
	}
	private String getKey(Locale locale,String url) {
		return url+locale.toString();
	}
	@Override
	public void clear(Locale locale, String url) {
		String key=getKey( locale, url);
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		cache.remove(key);
	}
	@Override
	public void clearAll() {
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		cache.removeAll();
	}
	@Override
	public Object getCache(Locale locale, String url) {
		String key=getKey( locale, url);
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		Element e =cache.get(key);
		if(e!=null) {
			return e.getObjectValue();
		}
		return null;
	}
}
