package com.example.blt.service;


import com.example.blt.dao.ConsoleDao;
import com.example.blt.entity.HostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by hongjian.chen on 2019/6/13.
 */

@Service
public class ConsoleService {
    @Autowired
    private ConsoleDao consoleDao;

    public void saveOrUpdate(HostInfo hostInfo) {
       consoleDao.saveAndFlush(hostInfo);
    }

}
