package com.tp.demo.controller;

import com.tp.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by after on 2018/8/24.
 */

@Controller
public class NormalController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/normal")
    public String testPage(Model mode){
        mode.addAttribute("msg",demoService.sayHello());
        return "test";
    }
}
