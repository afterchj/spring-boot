package com.example.demo.service.impl;

import com.isoft.after.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService(group = "${dubbo.provider.group}",version = "${dubbo.provider.version}")
public class DemoServiceImpl implements DemoService {


    @Value("${dubbo.provider.version}")
    private String version;

    @Override
    public String sayName(String name) {
        return String.format("%s_%s",name,version);
    }
}
