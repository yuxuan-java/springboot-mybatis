package org.spring.springboot.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.enums.BaseResultCodeEnum;
import org.spring.springboot.util.JacksonUtil;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 返回结果集封装
 *
 * @author yuxuan.han
 */
public class BaseResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4464525509870618467L;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseResult.class);
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("msg")
	private String msg;
	
	@JsonProperty("data")
	private T data;
	
	protected BaseResult(Exception e) {
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			this.code = BaseResultCodeEnum.FAILURE.getCode();
			this.msg = be.getBusinessMsg();
		} else {
			this.code = BaseResultCodeEnum.ERROR.getCode();
			this.msg = e.getLocalizedMessage();
		}
	}
	
	protected BaseResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	protected BaseResult(String code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	protected BaseResult(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	protected String toJson() {
		JacksonUtil instance = JacksonUtil.getInstance();
		try {
			return instance.object2Json(this);
		} catch (Exception e) {
			logger.error("######create BaseResult json error: ", e);
		}
		return this.toString();
	}

	@Override
	public String toString() {
		return "{\"code\":\"" + this.code + "\", \"msg\":\"" + this.msg + "\"}";
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
