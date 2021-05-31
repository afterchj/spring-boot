package com.example.demo.service.impl;

import com.isoft.after.api.ExternService;
import com.isoft.after.model.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Classname ExternServiceImpl
 * @Description TODO
 * @Date 2021/4/25 11:36
 * @Created by hjchen
 */

@DubboService(group = "${dubbo.provider.group}",version = "${dubbo.provider.version}")
public class ExternServiceImpl implements ExternService {

    @Value("${dubbo.provider.version}")
    private String version;

    @Override
    public UserDTO login(String s, String s1) {
        return new UserDTO().setUsername(s).setLoginType("rpc_"+version);
    }
}