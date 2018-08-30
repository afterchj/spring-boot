package com.tp.demo.controller;

import com.tp.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by after on 2018/8/24.
 */

@Controller
public class MyRestControoler {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public String testRest() {
        return demoService.sayHello();
    }
}
