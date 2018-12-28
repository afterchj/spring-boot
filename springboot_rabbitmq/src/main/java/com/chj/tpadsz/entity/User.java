package com.chj.tpadsz.entity;

import java.io.Serializable;

/**
 * Created by hongjian.chen on 2018/12/28.
 */
public class User implements Serializable {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "{" + "\"" + id + "\",\"" + name + "\"}";
    }

    public static void main(String[] args) {
        System.out.println(new User(101,"admin").toString());
    }
}
