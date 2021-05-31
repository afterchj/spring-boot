package com.example.demo;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@EnableAsync //开启异步任务支持   如果Application已经开启，则这个可以省略
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyDemoApplication {



    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if (viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("ctx", "/helloboot");
            viewResolver.setStaticVariables(vars);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MyDemoApplication.class, args);
//        new SpringApplicationBuilder(MyDemoApplication.class)
//                .run(args);
    }
}
