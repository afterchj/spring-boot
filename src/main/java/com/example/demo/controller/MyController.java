package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.ConfigBean;
import com.example.demo.entity.UserProperty;
import com.example.demo.entity.UserVo;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@RestController
@EnableConfigurationProperties({ConfigBean.class, UserProperty.class})
public class MyController {

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private UserService userService;

    @RequestMapping("/lucy")
    public String greeting() {
        return configBean.getGreeting() + "-" + configBean.getName() + "-" + configBean.getUuid() + "-" + configBean.getMax();
    }

    @Autowired
    private UserProperty userProperty;

    @RequestMapping("/user")
    public String user() {
        return userProperty.getName() + ":" + userProperty.getAge();
    }

    @RequestMapping(value = "/userList")
    public String listUser() {
        List<UserVo> list = userService.getAll();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/page")
    public PageInfo<UserVo> page(int pageNum) {
        return userService.getByPage(pageNum);
    }
}
