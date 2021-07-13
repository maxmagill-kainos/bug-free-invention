package com.bug.free.invention.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ApiApplication.class, args);
		} catch (Exception E) {
			E.printStackTrace();
		}

	}
}
