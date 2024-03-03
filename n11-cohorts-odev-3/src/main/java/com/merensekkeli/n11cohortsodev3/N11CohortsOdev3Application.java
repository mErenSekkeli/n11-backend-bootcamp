package com.merensekkeli.n11cohortsodev3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class N11CohortsOdev3Application {

	public static void main(String[] args) {
		SpringApplication.run(N11CohortsOdev3Application.class, args);
	}

}
