package com.example.demo;

import com.example.demo.service.MsgSendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MemcachedApplication {

    public static void main(String[] args) throws Exception {
        //ConfigurableApplicationContext ctx=
        SpringApplication.run(MemcachedApplication.class, args);
//        MsgSendService sendService=ctx.getBean(MsgSendService.class);
//        sendService.updateCheckOut("12", "18170756879");
    }
}
