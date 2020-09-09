package com.wingcode.suppermarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SuppermarketserviceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppermarketserviceapiApplication.class, args);
	}

}
