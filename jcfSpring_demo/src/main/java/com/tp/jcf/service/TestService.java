package com.tp.jcf.service;

import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/8/30.
 */

@Service
public class TestService {

    public void outputResult() {
        System.out.println("从组合注解配置获得的bean");
    }
}
