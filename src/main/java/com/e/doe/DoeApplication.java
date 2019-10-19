package com.e.doe;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoeApplication.class, args);
	}

}
