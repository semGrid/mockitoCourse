package com.griddynamics.banksinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BanksInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanksInformationApplication.class, args);
	}

}
