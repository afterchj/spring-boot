package com.example.demo.controller;

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
    private DemoServiceConsume consumeService;

    @GetMapping("/v1")
    public String test1() {
        return consumeService.test1();
    }
}
