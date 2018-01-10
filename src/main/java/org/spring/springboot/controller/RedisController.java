package org.spring.springboot.controller;

import org.spring.springboot.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * redis操作控制器
 *
 * @author yuxuan.han
 */
@Api(value="redis controller", tags = "redis相关操作")
@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private IRedisService redisService;
	
	@ApiOperation("测试redis链接")
	@RequestMapping(value = "/getUsername", method = RequestMethod.POST)
	public String getUsername() {
		return redisService.getUsername();
	}
	
}
