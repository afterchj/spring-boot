package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hongjian.chen on 2019/6/12.
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    @Query("FROM User where id=?1 and name=?2")
    User findByIdAndName(int id, String name);
}
