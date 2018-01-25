package org.spring.springboot.base;

import static org.spring.springboot.base.BaseResult.error;
import static org.spring.springboot.base.BaseResult.failure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共的Controller方法
 *
 * @author yuxuan.han
 */
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public BaseResult processException(Exception e) {
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			logger.warn("######set Hash warrning: ", be);
			return failure(be);
		} else {
			logger.error("######setHash error: ", e);
			return error();
		}
	}
	
}
