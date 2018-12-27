package com.example.demo;

import com.example.demo.exception.InvalidCodeException;
import com.example.demo.service.dubbo.MsgServiceConsume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DubboClientApplication.class, args);
        MsgServiceConsume sendService = ctx.getBean(MsgServiceConsume.class);
        String value = null;
        try {
//            String code = sendService.updateCheckOut("9", "18550791817");
//            System.out.println("code=" + code);
            value = sendService.checkValidation("505597", "18550791817");
        } catch (Exception e) {
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
