package com.example.demo.controller;

import com.example.demo.service.dubbo.ExternServiceConsume;
import com.isoft.after.api.DemoService;
import com.isoft.after.constants.Result;
import com.isoft.after.model.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hongjian.chen on 2018/12/12.
 */

@RestController
@RequestMapping("/zoo")
public class DemoController {

    @DubboReference(version = "0.1.0")
    public DemoService demoService1;

    @DubboReference(version = "0.2.0")
    public DemoService demoService2;

    @Autowired
    public ExternServiceConsume externService;

    @GetMapping("/v1")
    public String test1() {
        return demoService1.sayName("test");
    }

    @GetMapping("/v2")
    public String test2() {
        return demoService2.sayName("test");
    }

    @PostMapping("/login")
    public Result<UserDTO> login(@RequestBody UserDTO user) {
        return externService.login(user.getUsername(), user.getPassword());
    }
}
