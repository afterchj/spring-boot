package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * Created by after on 2019/6/13.
 */
public interface UserService{

    User findByIdAndName(int id, String name);

    User getById(int id);

    User save(User user);
}
