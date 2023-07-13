package com.niit.ResturantAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ResturantAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantAuthServiceApplication.class, args);
	}

}
