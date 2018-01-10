package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.IRedisService;
import org.spring.springboot.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import static org.spring.springboot.util.StringUtil.*;

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
	public City getCityById(String id) throws Exception {
		String json = redisTemplate.opsForValue().get(id);
		if (isNotEmpty(json)) {
			logger.debug("######get city from redis: {}", json);
			City city = JacksonUtil.getInstance().json2Model(json, City.class);
			return city;
		}
		return null;
	}

	@Override
	public void setCity(City city) throws Exception {
		String json = JacksonUtil.getInstance().object2Json(city);
		logger.debug("######set city to redis: {}", json);
		redisTemplate.opsForValue().set(city.getId().toString(), json);
	}
	
}
