package com.example.demo.controller;

import com.example.demo.service.dubbo.DemoServiceConsume;
import com.example.demo.service.dubbo.ExternServiceConsume;
import com.isoft.after.api.DemoService;
import com.isoft.after.api.ExternService;
import com.isoft.after.constants.Result;
import com.isoft.after.model.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@RestController
@RequestMapping("/zoo")
public class DemoConreoller {

    @Reference(version = "0.1.0")
    public DemoService demoService;

    @Reference
    public ExternService externService;

    @GetMapping("/test")
    public String test1() {
        return demoService.sayName("test");
    }

    @PostMapping("/login")
    public Result<UserDTO> login(@RequestBody UserDTO user) {
        return externService.login(user.getUsername(), user.getPassword());
    }
}
