package com.capgemini.project.micreservice_train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicreserviceTrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicreserviceTrainApplication.class, args);
	}

}
