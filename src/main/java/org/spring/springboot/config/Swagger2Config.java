package org.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * SwaggerUI配置类
 *
 * @author yuxuan.han
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.spring.springboot.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("yuxuan.han", "https://github.com/yuxuanjava", "han630389657@vip.qq.com");
		return new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful API")
				.description("简单优雅的restfun风格")
				.termsOfServiceUrl("http://localhost/swagger-ui.html#/")
				.contact(contact)
				.version("1.0")
				.build();
	}
	
}
