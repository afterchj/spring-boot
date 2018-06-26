package com.example.demo.controller;

import com.example.demo.entity.ConfigBean;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class MyController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/lucy")
    public String greeting() {
        return configBean.getGreeting() + "-" + configBean.getName() + "-" + configBean.getUuid() + "-" + configBean.getMax();
    }

    @Autowired
    User user;

    @RequestMapping("/user")
    public String user() {
        return user.getName() + ":" + user.getAge();
    }

}
