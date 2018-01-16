package org.spring.springboot.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.util.JacksonUtil;

/**
 * 返回结果集封装
 *
 * @author yuxuan.han
 */
public class BaseResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4464525509870618467L;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseResult.class);
	
	private String code;
	/**
	 * 返回状态码枚举类
	 *
	 * @author yuxuan.han
	 */
	public enum BaseResultCodeEnum {
		SUCCESS("000000", "成功"), FAILURE("111111", "失败"), ERROR("100000", "异常");
		
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
				if (e.code.equals(code)) 
					return e.description;
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
	
	private String msg;
	
	private Map<String, Object> data;
	
	public BaseResult(Exception e) {
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			this.code = BaseResultCodeEnum.FAILURE.getCode();
			this.msg = be.getBusinessMsg();
		} else {
			this.code = BaseResultCodeEnum.ERROR.getCode();
			this.msg = e.getLocalizedMessage();
		}
	}
	
	private BaseResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	private BaseResult(String code, Map<String, Object> data) {
		super();
		this.code = code;
		this.data = data;
	}

	private BaseResult(String code, String msg, Map<String, Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public String toJson() {
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
	
	public static final BaseResult success() {
		return new BaseResult(BaseResultCodeEnum.SUCCESS.getCode(), "成功");
	}
	
	public static final BaseResult success(String msg) {
		return new BaseResult(BaseResultCodeEnum.SUCCESS.getCode(), msg);
	}
	
	public static final BaseResult success(String msg, Map<String, Object> data) {
		return new BaseResult(BaseResultCodeEnum.SUCCESS.getCode(), msg, data);
	}
	
	public static final BaseResult successData(Map<String, Object> data) {
		return new BaseResult(BaseResultCodeEnum.SUCCESS.getCode(), data);
	}
	
	public static final String successJson() {
		return success().toJson();
	}
	
	public static final String successDataJson(Map<String, Object> data) {
		return successData(data).toJson();
	}
	
	public static final String successJson(String msg) {
		return success(msg).toJson();
	}
	
	public static final String successJson(String msg, Map<String, Object> data) {
		return success(msg, data).toJson();
	}
	
	public static final BaseResult failure() {
		return new BaseResult(BaseResultCodeEnum.FAILURE.getCode(), "失败");
	}
	
	public static final BaseResult failure(String msg) {
		return new BaseResult(BaseResultCodeEnum.FAILURE.getCode(), msg);
	}
	
	public static final BaseResult failure(String msg, Map<String, Object> data) {
		return new BaseResult(BaseResultCodeEnum.FAILURE.getCode(), msg, data);
	}
	
	public static final String failureJson() {
		return failure().toJson();
	}
	
	public static final String failureJson(String msg) {
		return failure(msg).toJson();
	}
	
	public static final String failureJson(String msg, Map<String, Object> data) {
		return failure(msg, data).toJson();
	}
	
	public static final BaseResult error() {
		return new BaseResult(BaseResultCodeEnum.ERROR.getCode(), "");
	}
	
	public static final BaseResult error(String msg) {
		return new BaseResult(BaseResultCodeEnum.ERROR.getCode(), msg);
	}
	
	public static final String errorJson() {
		return error().toJson();
	}
	
	public static final String errorJson(String msg) {
		return error(msg).toJson();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
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
	
	public static void main(String[] args) {
		System.out.println(BaseResult.successJson());
		System.out.println(BaseResult.success().toString());
	}
	
}
