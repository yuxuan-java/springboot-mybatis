package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.base.BaseResult;
import org.spring.springboot.dao.CityMapper;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.spring.springboot.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.spring.springboot.base.BaseResult.*;

/**
 * 城市业务逻辑实现类
 *
 * @author yuxuan.han
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityDao;
    
    @Autowired
    private IRedisService redisService;
    
    @SuppressWarnings("all")
    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    public City findCityByName(String cityName) {
    	City city = cityDao.findByName(cityName);
        return city;
    }

	@Override
	public BaseResult addCity(City city) {
		cityDao.save(city);
		return success();
	}

	@Override
	public City findCityById(String id) {
		City city = redisService.getCityById(id);
		
		if (city == null) {
			city = cityDao.selectByPrimaryKey(id);
			redisService.setCity(city);
		}
		return city;
	}

	@Override
	public BaseResult updateCity(City city) {
		cityDao.updateByPrimaryKey(city);
		redisService.deleteByKey(String.valueOf(city.getId()));
		return success();
	}

}