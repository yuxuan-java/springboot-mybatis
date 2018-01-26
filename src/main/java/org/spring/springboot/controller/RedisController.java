package org.spring.springboot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.base.BaseController;
import org.spring.springboot.base.BaseResult;
import org.spring.springboot.service.IRedisService;
import org.spring.springboot.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * redis操作控制器
 *
 * @author yuxuan.han
 */
@Api(value="redis controller", tags = "redis相关操作")
@RestController
@RequestMapping("/redis")
public class RedisController extends BaseController {
	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	@Autowired
	private IRedisService redisService;
	
	@ApiOperation("测试redis链接")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success !"), 
		@ApiResponse(code = 404, message = "Not Found !")
	})
	@RequestMapping(value = "/getUsername", method = RequestMethod.POST)
	public String getUsername() {
		return redisService.getUsername();
	}
	
	@ApiOperation("获取redis中String类型的值")
	@RequestMapping(value = "/getString", method = RequestMethod.POST)
	public String getString(@ApiParam("key for redis string") @RequestParam("key") String key) {
		return redisService.getString(key);
	}
	
	@ApiOperation("设置redis中String类型的值")
	@RequestMapping(value = "/setString", method = RequestMethod.POST)
	public BaseResult<?> setString(@ApiParam("key for redis string") @RequestParam("key") String key, 
			@ApiParam("value for redis string") @RequestParam("value") String value) {
		redisService.setString(key, value);
		return success();
	}
	
	@ApiOperation("获取redis中Hash结构的值")
	@RequestMapping(value = "/getHash", method = RequestMethod.POST)
	public Map<String, String> getHash(@ApiParam("key for redis hash") @RequestParam("key") String key) {
		Map<String, String> resultMap = redisService.getHash(key);
		return resultMap;
	}
	
	@ApiOperation("设置redis中Hash结构的值")
	@RequestMapping(value = "/setHash", method = RequestMethod.POST)
	public BaseResult<?> setHash(@ApiParam("key for redis hash") @RequestParam("key") String key, 
			@ApiParam("entry map json for redis hash") @RequestParam("json") String json) {
		JacksonUtil jackson = JacksonUtil.getInstance();
		try {
			Map<String, Object> map = jackson.json2Map(json);
			redisService.setHash(key, map);
			return success();
		} catch (Exception e) {
			return processException(e);
		}
	}
	
}
