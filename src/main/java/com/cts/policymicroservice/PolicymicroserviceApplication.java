package com.cts.policymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PolicymicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicymicroserviceApplication.class, args);
	}

}
