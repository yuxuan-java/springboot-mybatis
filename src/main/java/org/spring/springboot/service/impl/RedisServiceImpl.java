package org.spring.springboot.service.impl;

import static org.spring.springboot.util.StringUtil.isNotEmpty;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.IRedisService;
import org.spring.springboot.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis操作逻辑类
 *
 * @author yuxuan.han
 */
@Service
public class RedisServiceImpl implements IRedisService{
	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public String getUsername() {
		return redisTemplate.opsForValue().get("username");
	}

	@Override
	public City getCityById(String id) {
		String json = redisTemplate.opsForValue().get(id);
		if (isNotEmpty(json)) {
			try {
				City city = JacksonUtil.getInstance().json2Model(json, City.class);
				logger.debug("######get city from redis: {}", json);
				return city;
			} catch (Exception e) {
				logger.error("######RedisServiceImpl json2Model error: ", e);
			}
		}
		return null;
	}

	@Override
	public void setCity(City city) {
		try {
			String json = JacksonUtil.getInstance().object2Json(city);
			logger.debug("######set city to redis: {}", json);
			redisTemplate.opsForValue().set(city.getId().toString(), json);
		} catch (Exception e) {
			logger.error("######RedisServiceImpl object2Json error: ", e);
		}
	}

	@Override
	public void deleteByKey(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public String getString(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void setString(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	@Override
	public Map<String, String> getHash(String key) {
		HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
		Map<String, String> resultMap = opsForHash.entries(key);
		return resultMap;
	}

	@Override
	public void setHash(String key, Map<String, Object> map) {
		BoundHashOperations<String, String, Object> boundHashOps = redisTemplate.boundHashOps(key);
		boundHashOps.putAll(map);
	}
	
}
