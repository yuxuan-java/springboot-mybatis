package org.spring.springboot.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 城市实体类
 *
 * @author yuxuan.han
 */
@ApiModel("城市实体类")
public class City implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2081742442561524068L;

	/**
     * 城市编号
     */
	@ApiModelProperty("城市编号")
    private Long id;

    /**
     * 省份编号
     */
	@ApiModelProperty("省份编号")
    private Long provinceId;

    /**
     * 城市名称
     */
	@ApiModelProperty("城市名称")
    private String cityName;

    /**
     * 描述
     */
	@ApiModelProperty("描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
