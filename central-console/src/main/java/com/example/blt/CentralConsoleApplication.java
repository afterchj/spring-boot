package com.example.blt;

import com.example.blt.netty.ServerMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralConsoleApplication.class, args);
		new ServerMain().run(8000);
	}
}
