package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.dubbo.ConsumeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DubboClientApplication.class, args);
        ConsumeService consumeService=ctx.getBean(ConsumeService.class);
        System.out.println("test version="+ JSON.toJSONString(consumeService.test1()));
        System.out.println("test version="+JSON.toJSONString(consumeService.test2()));
        System.out.println("test version="+JSON.toJSONString(consumeService.test0()));
    }
}
