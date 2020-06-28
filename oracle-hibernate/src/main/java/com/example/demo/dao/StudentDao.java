package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @Classname BasClassDao
 * @Description TODO
 * @Date 2020/6/19 17:16
 * @Created by hjchen
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query("update Student set name=:name where id=:id")
    void saveUpdate(@Param(value = "name") String name, @Param(value = "id") Integer id);

    @Query("FROM Student where id=?1")
    Student getById(int id);
}
