package com.example.blt;

import com.example.blt.netty.ServerMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CentralConsoleApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CentralConsoleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CentralConsoleApplication.class, args);
//        ServerMain.run(8001);
    }
}
