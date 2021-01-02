package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@Entity
public class Info extends BaseEntity{


    @Column(nullable = false,unique =true)
    private String userName;

    @Column
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
