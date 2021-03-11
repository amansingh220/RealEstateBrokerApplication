package com.capg.rba;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.capg.rba"))
				.build()
				.apiInfo(getApiInfo());
	}
    
    private ApiInfo getApiInfo() {
	    return new ApiInfo(
		    "Real Estate Broker Application",
		    "Authors: Aman Singh, Aditya Shrivastava, Anjani Mehta, Arpit Agnihotri, Ayush Mittal, Deepak Kumar",
		    "1.0.0",
		    "https://rba.capg.com",
		    new Contact("Batch 1, Group 4 FS","https://capgemini.com","group4@rba.life"),
		    "GNU V3",
		    "LICENSE URL",
		    Collections.emptyList()
	    );
	}
}
