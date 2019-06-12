package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hongjian.chen on 2019/6/12.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/add")
    public User add() {
        User user = new User();
        user.setName("毕胜");
        user.setAge(25);
        User result = userRepository.save(user);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public List<User> getAll(){
        List<User> list=userRepository.findAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("/update")
    public User update(int id,int age,String name){
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        User result = userRepository.save(user);
        return result;
    }
}
