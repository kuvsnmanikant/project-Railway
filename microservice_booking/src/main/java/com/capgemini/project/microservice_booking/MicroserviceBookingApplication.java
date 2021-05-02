package com.capgemini.project.microservice_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class MicroserviceBookingApplication {
	@Bean
	@LoadBalanced
	public RestTemplate gRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBookingApplication.class, args);
	}

}
