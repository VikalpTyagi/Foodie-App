package com.bej.springcloudapigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins ="http://localhost:4200")
@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                        .uri("http://localhost:8081/")) // use the name of the application in the uri
                 .route(p->p
                        .path("/api/v2/**")
                        .uri("http://localhost:8088/"))
                .route(p -> p
                        .path("/api/v3/**")
                        .uri("http://localhost:8666/"))
                .route(p -> p
                        .path("/api/v4/**")
                        .uri("http://localhost:8888/"))
                .route(p -> p
                        .path("/api/v5/**")
                        .uri("http://localhost:8086/"))
                .build();
    }

}


