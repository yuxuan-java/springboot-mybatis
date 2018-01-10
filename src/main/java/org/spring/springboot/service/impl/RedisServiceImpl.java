package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis操作逻辑类
 *
 * @author yuxuan.han
 */
@Service
public class RedisServiceImpl implements IRedisService{
	
	private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public String getUsername() {
		return redisTemplate.opsForValue().get("username");
	}
	
}
