package com.tp.demo.controller;

import com.tp.demo.dao.UserDao;
import com.tp.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@RestController
@RequestMapping(value = "/rest")
public class DemoResetController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8")
    public User getJson(User user) {
        return new User(user.getId() + 1, user.getLoginName() + "_json");
    }

    @ResponseBody
    @RequestMapping(value = "/getXml", produces = "application/xml;charset=UTF-8")
    public User getXml(User user) {
        return new User(user.getId() + 1, user.getLoginName() + "_xml");
    }

    @ResponseBody
    @RequestMapping(value = "/listUser", produces = "application/json;charset=UTF-8")
    public List<User> getList() {
        return userDao.getAll();
    }
}
