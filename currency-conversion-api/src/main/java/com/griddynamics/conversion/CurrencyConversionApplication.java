package com.griddynamics.conversion;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConversionApplication {

	private final static Logger LOGGER = Logger.getLogger(CurrencyConversionApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Run currency conversion application");
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
}
