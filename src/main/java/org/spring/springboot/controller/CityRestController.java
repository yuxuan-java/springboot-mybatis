package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
