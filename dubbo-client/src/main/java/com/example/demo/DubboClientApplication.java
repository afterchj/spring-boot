package com.example.demo;

import com.example.demo.service.dubbo.DemoServiceConsume;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDubbo
@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DubboClientApplication.class, args);
        DemoServiceConsume sendService = ctx.getBean(DemoServiceConsume.class);
        String value = null;
        try {
            value = sendService.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("value=" + value);
    }
}
