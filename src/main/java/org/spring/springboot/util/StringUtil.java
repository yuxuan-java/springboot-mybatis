package org.spring.springboot.util;

/**
 * String 工具类
 *
 * @author yuxuan.han
 */
public class StringUtil {
	
	/**
	 * str为空返回true
	 * @param str
	 * @return
	 */
	public static final boolean isEmpty(String str) {
		if (str == null || str.equals("") || str.length() == 0 || str.equals("null")) {
			return true;
		}
		return false;
	}
	
	/**
	 * str不为空返回true
	 * @param str
	 * @return
	 */
	public static final boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
}
