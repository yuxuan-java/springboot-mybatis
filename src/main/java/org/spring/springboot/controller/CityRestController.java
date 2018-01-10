package org.spring.springboot.controller;

import org.spring.springboot.base.BaseResult;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Web控制器
 *
 * @author yuxuan.han
 */
@Api(value="CityRestController", tags = "城市相关操作")
@RestController
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @ApiOperation("根据名称查找城市")
    @RequestMapping(value = "/findCityByName", method = RequestMethod.POST)
    public City findOneCity(
		@ApiParam("城市名称") @RequestParam(value = "cityName", required = true) String cityName
    ) {
    	City city = cityService.findCityByName(cityName);
        return city;
    }
    
    @ApiOperation("添加城市")
    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public BaseResult addCity(@ApiParam("") @RequestBody City city) {
    	BaseResult result = cityService.addCity(city);
    	return result;
    }
    
    @ApiOperation("根据Id查询")
    @RequestMapping(value = "/findCityById", method = RequestMethod.POST)
    public City findCityById(@ApiParam("主键Id") @RequestBody String id) {
    	City city = cityService.findCityById(id);
    	return city;
    }
    
    @ApiOperation("更新城市信息")
    @RequestMapping(value = "/updateCity", method = RequestMethod.POST)
    public BaseResult updateCity(@RequestBody City city) {
    	BaseResult result = cityService.updateCity(city);
    	return result;
    }
    
}
