package com.haojii;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket groupDemoDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Demo").select().apis(
				basePackage("com.haojii.controller")).build().apiInfo(apiInfo());
	}
	
	@Bean
	public Docket groupHealthDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Health").select().apis(
				not(basePackage("com.haojii.controller"))).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Api Documentation", "Rest Api Documentation with Swagger + springfox", "1.0", "urn:tos",
		          "rest-demo@haojii.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
