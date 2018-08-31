package com.example.demo.entity;

import java.util.Date;

/**
 * Created by hongjian.chen on 2018/8/31.
 */
public class TestVo {
    private String name;
    private  Integer score;
    private  Integer male;
    private Date birthday;

    public TestVo(String name, Integer score, Date birthday, Integer male) {
        this.name = name;
        this.score = score;
        this.male = male;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
