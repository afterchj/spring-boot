package com.example.demo.dao;

import com.example.demo.entity.Info;
import com.example.demo.entity.PersonVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/6/26.
 */
public interface InfoDao extends JpaRepository<Info, Long> {


    Info findByUserName(String userName);

    Info findInfoById(Long id);


}
