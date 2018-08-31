package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hongjian.chen on 2018/8/30.
 */
@ConfigurationProperties(prefix = "my")
public class HelloServiceProperties {
    private static final String MSG = "World";

    private String msg=MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
