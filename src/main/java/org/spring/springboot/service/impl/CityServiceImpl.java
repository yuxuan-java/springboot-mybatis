package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.CityMapper;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.spring.springboot.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    public City findCityByName(String cityName) {
    	City city = cityDao.findByName(cityName);
        return city;
    }

	@Override
	public void addCity(City city) {
		cityDao.save(city);
	}

	@Override
	public City findCityById(String id) {
		City city = null;
		try {
			city = redisService.getCityById(id);
		} catch (Exception e) {
			logger.error("######redisService.getCityById", e);
		}
		
		if (city == null) {
			city = cityDao.findById(id);
			try {
				redisService.setCity(city);
			} catch (Exception e) {
				logger.error("######redisService.setCity", e);
			}
		}
		return city;
	}

}