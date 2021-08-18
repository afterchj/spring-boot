package com.example.demo.dao;

import com.example.demo.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Classname UserRepository
 * @Description TODO
 * @auth after
 * @since 2021/8/18 22:37
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select account,username from User b where b.account = :account")
    User findByAccount(@Param("account") String account);
}
