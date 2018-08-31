package com.example.demo.service;

/**
 * Created by hongjian.chen on 2018/8/30.
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "Hello "+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
