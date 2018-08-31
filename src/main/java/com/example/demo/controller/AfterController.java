package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/6/25.
 */
@RestController
public class AfterController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @Value("${my.greeting}")
    private String hello;

    @RequestMapping("/after")
    public String after() {

        return name + ":" + age + "." + hello;
    }
}
