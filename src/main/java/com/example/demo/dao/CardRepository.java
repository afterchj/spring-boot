package com.example.demo.dao;

import com.example.demo.entity.model.IDCard;
import com.example.demo.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @auth after
 * @since 2021/8/18 22:37
 */
public interface CardRepository extends JpaRepository<IDCard, Long> {
}
