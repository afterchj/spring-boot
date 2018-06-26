package com.example.demo.service;

import com.example.demo.dao.InfoDao;
import com.example.demo.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@Service
public class InfoService {

    @Autowired
    private InfoDao infoDao;

    public Info findByUserName(String userName) {
        return infoDao.findByUserName(userName);
    }

    public List<Info> findAll() {
        return infoDao.findAll();
    }

    public Info saveInfo(Info info) {
        return infoDao.save(info);
    }

    public Info findById(Long id) {
        return infoDao.findInfoById(id);
    }

    public Info updateUser(Info info) {
        return infoDao.saveAndFlush(info);
    }

    public void deleteUser(Long id) {
        infoDao.deleteById(id);
    }
}
