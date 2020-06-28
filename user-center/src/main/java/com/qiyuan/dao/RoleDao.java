package com.qiyuan.dao;


import com.qiyuan.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    List<Role> getUserRoleByUserId(int id);

    List<Map> getAll();

    void insertUserRole(Map userRole);

}
