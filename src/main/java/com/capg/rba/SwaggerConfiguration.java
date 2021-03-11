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
				.paths(PathSelectors.regex("/rba.*"))
				.apis(RequestHandlerSelectors.basePackage("com.capg.rba"))
				.build()
				.apiInfo(getApiInfo());
	}
    
    private ApiInfo getApiInfo() {
	    return new ApiInfo(
		    "Cab Booking Application",
		    "Authors: Ankitha Suraksha, Arfath Pasha, Ashutosh Rao Chawan U, Bharat Singh, D Sri Madhu Priya, Farooq Shaik Mohammad",
		    "1.0.0",
		    "https://cba.cg.com",
		    new Contact("Batch 1, Group 1 DCX","https://capgemini.com","group1@rao.life"),
		    "GNU V3",
		    "LICENSE URL",
		    Collections.emptyList()
	    );
	}
}
