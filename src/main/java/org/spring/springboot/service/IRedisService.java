package org.spring.springboot.service;

import org.spring.springboot.domain.City;

public interface IRedisService {

	String getUsername();
	
	/**
	 * 根据Id获取缓存中的值
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	City getCityById(String id) throws Exception;
	
	/**
	 * 添加缓存
	 * @param city
	 * @throws Exception 
	 */
	void setCity(City city) throws Exception;

}
