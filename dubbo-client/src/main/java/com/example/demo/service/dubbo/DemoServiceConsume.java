package com.example.demo.service.dubbo;

import com.isoft.after.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Service
public class DemoServiceConsume {

    @Reference(version = "0.1.0")
    public DemoService demoService1;


    public String test1() {
        return demoService1.sayName("version 1");
    }
}
