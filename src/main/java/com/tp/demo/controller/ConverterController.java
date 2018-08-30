package com.tp.demo.controller;

import com.tp.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
public class ConverterController {

    @ResponseBody
    @RequestMapping(value = "/convert",produces = {"application/x-wisely"})
    public User convert(@RequestBody User user){
        return user;
    }
}
