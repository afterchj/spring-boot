package com.example.demo.service.impl;

import com.isoft.after.api.ExternService;
import com.isoft.after.model.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Classname ExternServiceImpl
 * @Description TODO
 * @Date 2021/4/25 11:36
 * @Created by hjchen
 */

@Service(version = "0.2.0")
public class ExternServiceImpl implements ExternService {

    @Override
    public UserDTO login(String s, String s1) {
        return new UserDTO().setUsername(s).setLoginType("rpc");
    }
}