package com.example.demo.entity;

/**
 * Created by hongjian.chen on 2018/8/30.
 */
public class PersonVo {
    private String name;
    private int age;

    public PersonVo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
