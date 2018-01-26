package org.spring.springboot.service;

import org.spring.springboot.domain.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 * @author yuxuan.han
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
    
    /**
     * 添加城市
     * @param city
     * @return 
     */
	void addCity(City city);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	City findCityById(String id);
	
	/**
	 * 更新城市信息
	 * @param city
	 * @return
	 */
	void updateCity(City city);
}
