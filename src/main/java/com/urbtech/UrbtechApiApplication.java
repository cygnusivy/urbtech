package com.urbtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "config")
public class UrbtechApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(UrbtechApiApplication.class, args);
	}

}