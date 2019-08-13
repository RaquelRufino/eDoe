package com.e.doe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.e.doe.models")
@SpringBootApplication
public class DoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoeApplication.class, args);
	}

}
