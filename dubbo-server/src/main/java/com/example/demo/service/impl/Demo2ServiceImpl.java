package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.isoft.after.api.DemoService;

/**
 * Created by hongjian.chen on 2018/12/12.
 */
@Service(version = "2.0.0")
public class Demo2ServiceImpl implements DemoService {

    @Override
    public String sayName(String s) {
        return "version " + s;
    }
}
