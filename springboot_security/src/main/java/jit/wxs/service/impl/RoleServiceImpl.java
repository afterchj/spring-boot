package jit.wxs.service.impl;

import jit.wxs.dao.RoleDao;
import jit.wxs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Map> getAll() {
        return roleDao.getAll();
    }

    @Override
    public void insertUserRole(Map userRole) {
        try {
            roleDao.insertUserRole(userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
