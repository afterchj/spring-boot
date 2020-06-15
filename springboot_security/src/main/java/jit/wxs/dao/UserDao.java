package jit.wxs.dao;

import jit.wxs.model.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    UserEntity getUserByUsername(String username);

    /**
     * 新增用户
     *
     * @param user
     */
    void insertUser(UserEntity user);

    List<Map> getAll();

}
