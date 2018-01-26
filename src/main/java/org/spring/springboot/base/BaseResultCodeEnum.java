package org.spring.springboot.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回状态码枚举类
 *
 * @author yuxuan.han
 */
public enum BaseResultCodeEnum {
	//	成功
	SUCCESS("000000", "成功"), 
	//	业务异常
	FAILURE("111111", "失败"), 
	//	系统异常
	ERROR("100000", "异常");
	
	private String code;
	private String description;
	
	private BaseResultCodeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDescription(String code) {
		for (BaseResultCodeEnum e : values()) {
			if (e.code.equals(code)) {
				return e.description;
			}
		}
		return null;
	}
	
	/**
	 * @return Map<code, description>
	 */
	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (BaseResultCodeEnum e : values()) {
			map.put(e.code, e.description);
		}
		return map;
	}
}