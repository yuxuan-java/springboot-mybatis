package org.spring.springboot.service;

import java.util.Map;

import org.spring.springboot.domain.City;

public interface IRedisService {

	String getUsername();
	
	/**
	 * 根据Id获取缓存中的值
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	City getCityById(String id);
	
	/**
	 * 添加缓存
	 * @param city
	 * @throws Exception 
	 */
	void setCity(City city);
	
	/**
	 * 删除缓存
	 * @param city
	 */
	void deleteByKey(String key);
	
	/**
	 * 获取指定key的String值
	 * @param key
	 * @return
	 */
	String getString(String key);
	
	/**
	 * 设置指定key的String值
	 * @param key	key for redis string
	 * @param value value for redis string
	 */
	void setString(String key, String value);
	
	/**
	 * 获取指定key的Hash值
	 * @param key 
	 * @return
	 */
	Map<String, String> getHash(String key);
	
	/**
	 * 设置redis中Hash结构的值
	 * @param key
	 * @param map
	 */
	void setHash(String key, Map<String, Object> map);

}
