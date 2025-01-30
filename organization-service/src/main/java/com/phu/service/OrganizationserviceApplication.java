package com.phu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.phu.service")
public class OrganizationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationserviceApplication.class, args);
	}

}
