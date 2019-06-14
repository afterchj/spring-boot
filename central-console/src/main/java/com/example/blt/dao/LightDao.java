package com.example.blt.dao;

import com.example.blt.entity.LightInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hongjian.chen on 2019/6/13.
 */
public interface LightDao extends JpaRepository<LightInfo, Integer> {
    LightInfo getByVaddr(String vaddr);
}
