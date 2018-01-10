package org.spring.springboot.base;

/**
 * 业务异常
 *
 * @author yuxuan.han
 */
public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6961960238139034164L;
	
	private String businessCode;
	
	private String businessMsg;

	public BusinessException(String businessCode, String businessMsg) {
		super();
		this.businessCode = businessCode;
		this.businessMsg = businessMsg;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessMsg() {
		return businessMsg;
	}

	public void setBusinessMsg(String businessMsg) {
		this.businessMsg = businessMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
