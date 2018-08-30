package com.tp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
public class HomeController {
    @RequestMapping(value = "/index")
    public String hello(){
        System.out.println("show="+System.currentTimeMillis());
        return "index";
    }
}
