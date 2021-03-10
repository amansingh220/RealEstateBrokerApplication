package com.capg.rba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration class for spring-fox swagger2.
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	//apiDocket method Generates document for application's APIs. 
	@Bean
	public Docket apiDocket() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.capg.rba"))
				.paths(PathSelectors.any()).build();
		return docket;
	}

	// Define getApi info method for the customization of document header.
	/*
	 * public ApiInfo getApiInfo() {
	 * 
	 * }
	 */
}
