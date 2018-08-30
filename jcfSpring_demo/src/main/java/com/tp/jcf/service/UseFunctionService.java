package com.tp.jcf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/8/27.
 */

//@Service
public class UseFunctionService {


    private FunctionService functionService;

    @Autowired
    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }


    public String sayHello(String msg) {

        return functionService.sayHello(msg);
    }
}
