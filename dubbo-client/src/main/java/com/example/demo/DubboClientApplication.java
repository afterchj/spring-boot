package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.exception.InvalidCodeException;
import com.example.demo.service.dubbo.ConsumeService;
import com.example.demo.service.dubbo.DemoServiceConsume;
import com.example.demo.service.dubbo.MsgServiceConsume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(DubboClientApplication.class, args);
        MsgServiceConsume sendService=ctx.getBean(MsgServiceConsume.class);
        String value = null;
        try {
            value = sendService.checkValidation("123456", "18550791817");
        } catch (InvalidCodeException e) {
            e.printStackTrace();
        }
        System.out.println("value=" + value);
//        ConsumeService consumeService=ctx.getBean(ConsumeService.class);
//        DemoServiceConsume demoServiceConsume=ctx.getBean(DemoServiceConsume.class);
//        System.out.println("test version="+JSON.toJSONString(demoServiceConsume.test0()));
//        System.out.println("test version="+ JSON.toJSONString(demoServiceConsume.test1()));
//        System.out.println("test version="+JSON.toJSONString(demoServiceConsume.test2()));
    }
}
