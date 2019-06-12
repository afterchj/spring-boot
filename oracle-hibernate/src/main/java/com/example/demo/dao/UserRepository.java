package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hongjian.chen on 2019/6/12.
 */

public interface UserRepository extends JpaRepository<User, Integer> {

}
