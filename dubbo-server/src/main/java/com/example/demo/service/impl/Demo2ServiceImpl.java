package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.DemoService;

/**
 * Created by hongjian.chen on 2018/12/12.
 */
@Service(version = "2.0.0")
public class Demo2ServiceImpl implements DemoService {
    @Override
    public String version(String v) {
        return "version " + v;
    }
}