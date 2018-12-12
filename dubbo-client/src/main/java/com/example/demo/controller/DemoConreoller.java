package com.example.demo.controller;

import com.example.demo.service.DemoService;
import com.example.demo.service.dubbo.ConsumeService;
import com.example.demo.service.dubbo.DemoServiceConsume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@RestController
@RequestMapping("/zoo")
public class DemoConreoller {

    @Autowired
    DemoServiceConsume consumeService;

    @GetMapping("/v0")
    public Map test0() {
        return consumeService.test0();
    }

    @GetMapping("/v1")
    public String test1() {
        return consumeService.test1();
    }

    @GetMapping("/v2")
    public String test2() {
        return consumeService.test2();
    }
}
