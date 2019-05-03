package com.xiang.server.impl;

import java.util.List;

import org.springframework.util.ObjectUtils;

import com.google.common.collect.Lists;
import com.xiang.server.CacheServer;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author xiang
 * @createDate 2018年12月20日 下午2:18:51
 */
public class EhCacheServerImpl implements CacheServer {
	private final static String CACHENAME = "pageCache";

	@Override
	public void setCache(String key, Object data, long seconds) {
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		Element e = new Element(key, data, false);
		if (seconds > 0) {
			e.setTimeToLive((int) seconds);
		}
		cache.put(e);
		return;
	}

	@Override
	public void clear(String key) {
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
	public Object getCache(String key) {
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		Element e = cache.get(key);
		if (e != null) {
			return e.getObjectValue();
		}
		return null;
	}

	@Override
	public void setCache(String key, Object data) {
		setCache(key, data, 0);
	}

	@Override
	public void clearAll(String namespace) {
		CacheManager manager = CacheManager.getInstance();
		Cache cache = manager.getCache(CACHENAME);
		List list = cache.getKeys();
		if (ObjectUtils.isEmpty(list)) {
			return;
		}
		List<String> removeList = Lists.newArrayList();
		for (Object key : list) {
			if (key instanceof String) {
				String cacheKey = (String) key;
				if (cacheKey.startsWith(namespace)) {
					removeList.add(cacheKey);
				}
			}
		}
		if (!ObjectUtils.isEmpty(removeList)) {
			cache.removeAll(removeList);
		}
	}
}
