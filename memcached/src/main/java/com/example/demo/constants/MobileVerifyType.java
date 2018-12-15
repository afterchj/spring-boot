package com.example.demo.constants;

/**
 * Created by hongjian.chen on 2018/12/13.
 */

public enum MobileVerifyType {
    REGISTER("register_"),
    UPDATE("update_");

    private String value;

    MobileVerifyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
