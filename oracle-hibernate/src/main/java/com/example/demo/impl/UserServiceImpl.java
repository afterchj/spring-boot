package com.example.demo.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserProperty;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by after on 2019/6/13.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByIdAndName(int id, String name) {
        return userRepository.findByIdAndName(id,name);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
