package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityMapper {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
    
    /**
     * 添加城市
     * @param city
     */
	void save(City city);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	City selectByPrimaryKey(@Param("id") String id);
	
	/**
	 * 根据主键更新
	 * @param city
	 */
	void updateByPrimaryKey(City city);
}
