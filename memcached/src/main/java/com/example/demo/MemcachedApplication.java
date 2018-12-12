package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemcachedApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(MemcachedApplication.class, args);
		ValidationMessageSender.show();
	}
}
