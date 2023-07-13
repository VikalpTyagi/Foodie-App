package com.bej.springcloudapigateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class SpringCloudApiGatewayApplication {

	public static void main(String[] args) {
		System.out.println("main method");
		SpringApplication.run(SpringCloudApiGatewayApplication.class, args);
	}

}
