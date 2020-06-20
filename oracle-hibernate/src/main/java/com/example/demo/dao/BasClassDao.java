package com.example.demo.dao;

import com.example.demo.entity.BasClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname BasClassDao
 * @Description TODO
 * @Date 2020/6/19 17:16
 * @Created by hjchen
 */
public interface BasClassDao extends JpaRepository<BasClass, Integer> {
}
