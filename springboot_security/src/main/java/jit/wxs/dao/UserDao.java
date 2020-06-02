package jit.wxs.dao;

import jit.wxs.model.UserEntity;

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

}
