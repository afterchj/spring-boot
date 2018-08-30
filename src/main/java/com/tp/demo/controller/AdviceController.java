package com.tp.demo.controller;

import com.tp.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongjian.chen on 2018/8/24.
 */
@Controller
public class AdviceController {

    @RequestMapping(value = "/advice")
    public String getSomething(@ModelAttribute("msg") String msg, User user) {
        throw new IllegalArgumentException("非常抱歉，参数有误/来自@ModelAttributes:" + msg);
    }
}
