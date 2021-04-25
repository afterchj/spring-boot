package com.example.demo.service.impl;

import com.isoft.after.api.ExternService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Classname ExternServiceImpl
 * @Description TODO
 * @Date 2021/4/25 11:36
 * @Created by hjchen
 */

@Service(version = "0.1.0")
public class ExternServiceImpl implements ExternService {
    @Override
    public String echo(String s) {
        return String.format("echo [ %s ]", s);
    }
}