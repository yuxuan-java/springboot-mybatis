package org.spring.springboot.config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
/**
 * OkHttp配置类
 *
 * @author yuxuan.han
 */
//@Configuration
public class OkHttpConfig {
	
//	@Bean
	public OkHttpClient okHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		builder.connectTimeout(30, TimeUnit.SECONDS)
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.retryOnConnectionFailure(true);
		return builder.build();
	}
	
}
