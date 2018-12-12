package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.dubbo.ConsumeService;
import com.example.demo.service.dubbo.DemoServiceConsume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DubboClientApplication.class, args);
//        ConsumeService consumeService=ctx.getBean(ConsumeService.class);
        DemoServiceConsume demoServiceConsume=ctx.getBean(DemoServiceConsume.class);
        System.out.println("test version="+JSON.toJSONString(demoServiceConsume.test0()));
        System.out.println("test version="+ JSON.toJSONString(demoServiceConsume.test1()));
        System.out.println("test version="+JSON.toJSONString(demoServiceConsume.test2()));
    }
}
