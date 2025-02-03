package com.phu.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.ContextConfiguration;

@EnableDiscoveryClient
@SpringBootTest(classes = EmployeeserviceApplication.class)
@ContextConfiguration(classes = EmployeeserviceApplication.class)
class EmployeeserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
