package com.motorcyclebg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MotorcycleBGApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorcycleBGApplication.class, args);
	}

}
