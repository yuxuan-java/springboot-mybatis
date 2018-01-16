package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * @author yuxuan.han
 */
@SpringBootApplication						// Spring Boot 应用的标识
@MapperScan("org.spring.springboot.dao")	// mapper 接口类扫描包配置
public class Application {
	
	/**
	 * Application entrance
	 * http://localhost/swagger-ui.html
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }
    
}