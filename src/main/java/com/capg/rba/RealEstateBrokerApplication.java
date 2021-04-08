package com.capg.rba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class RealEstateBrokerApplication {
	private final static Logger log = LogManager.getLogger(RealEstateBrokerApplication.class);

	public static void main(String[] args) {
		log.info("Real Estate Broker Application Started");
		SpringApplication.run(RealEstateBrokerApplication.class, args);
	}

}
