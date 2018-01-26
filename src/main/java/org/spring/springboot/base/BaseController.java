package org.spring.springboot.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.enums.BaseResultCodeEnum;

/**
 * 公共的Controller方法
 *
 * @author yuxuan.han
 */
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public final <T> BaseResult<T> processException(Exception e) {
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			logger.warn("######set Hash warrning: ", be);
			return failure(be);
		} else {
			logger.error("######setHash error: ", e);
			return error();
		}
	}
	
	protected final <T> BaseResult<T> success() {
		return new BaseResult<T>(BaseResultCodeEnum.SUCCESS.getCode(), "成功");
	}
	
	protected final <T> BaseResult<T> success(String msg) {
		return new BaseResult<T>(BaseResultCodeEnum.SUCCESS.getCode(), msg);
	}
	
	protected final <T> BaseResult<T> success(String msg, T data) {
		return new BaseResult<T>(BaseResultCodeEnum.SUCCESS.getCode(), msg, data);
	}
	
	protected final <T> BaseResult<T> success(T data) {
		return new BaseResult<T>(BaseResultCodeEnum.SUCCESS.getCode(), data);
	}
	
	protected final <T> BaseResult<T> failure() {
		return new BaseResult<T>(BaseResultCodeEnum.FAILURE.getCode(), "失败");
	}
	
	protected final <T> BaseResult<T> failure(String msg) {
		return new BaseResult<T>(BaseResultCodeEnum.FAILURE.getCode(), msg);
	}
	
	protected final <T> BaseResult<T> failure(String msg, T data) {
		return new BaseResult<T>(BaseResultCodeEnum.FAILURE.getCode(), msg, data);
	}
	
	protected final <T> BaseResult<T> failure(BusinessException e) {
		return new BaseResult<T>(BaseResultCodeEnum.FAILURE.getCode(), e.getBusinessMsg());
	}
	
	protected final <T> BaseResult<T> error() {
		return new BaseResult<T>(BaseResultCodeEnum.ERROR.getCode(), "");
	}
	
	protected final <T> BaseResult<T> error(String msg) {
		return new BaseResult<T>(BaseResultCodeEnum.ERROR.getCode(), msg);
	}
	
}
