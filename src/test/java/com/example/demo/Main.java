package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by hongjian.chen on 2018/9/10.
 */
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder econd = new BCryptPasswordEncoder();
        String str=econd.encode("wyf");
        System.out.println(str);
    }
}
