package org.spring.springboot.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.spring.springboot.base.BaseResult;

/**
 * 小的测试类
 *
 * @author yuxuan.han
 */
public class TestDemo {
	
	@Test
	public void testHashCode() {
		
		List<BaseResult> cityList = new ArrayList<BaseResult>();
		cityList.add(BaseResult.success());
		cityList.add(BaseResult.failure());
		cityList.add(BaseResult.error());
		
		int code = 0;
		BaseResult next;
		for (Iterator<BaseResult> iterator = cityList.iterator(); iterator.hasNext(); ) {
			next = iterator.next();
			code += next.hashCode();
			System.out.println(next.getMsg() + ": " + next.hashCode());
		}
		System.out.println(code);
	}
	
}
