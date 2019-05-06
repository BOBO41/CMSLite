package com.xiang.server.impl;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.ObjectUtils;

import com.xiang.server.CacheServer;

public class RedisServerImpl implements CacheServer {
	private RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void setCache(String key, Object data, long seconds) {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		if (seconds > 0) {
			operations.set(key, data, seconds, TimeUnit.SECONDS);
		} else {
			operations.set(key, data);
		}
	}

	@Override
	public Object getCache(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void setCache(String key, Object data) {
		setCache(key, data, 0);
	}

	@Override
	public void clear(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void clearAll() {
		//慎用
		redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return null;
			}
		});
	}

	@Override
	public void clearAll(String namespace) {
		//慎用
		Set<String> keys = redisTemplate.keys(namespace + "*");
		if (!ObjectUtils.isEmpty(keys)) {
			redisTemplate.delete(keys);
		}
	}
}
