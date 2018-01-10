package org.spring.springboot.service.impl;

import org.spring.springboot.dao.CityMapper;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
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
		City city = cityDao.findById(id);
		return city;
	}

}
