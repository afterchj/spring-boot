package com.qiyuan.service;

import com.baomidou.mybatisplus.service.IService;
import com.qiyuan.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jitwxs
 * @since 2018-03-20
 */
public interface IUserService extends IService<User> {
    User findByName(String name);
    List<User> findAll();
    void insertUser(User user);
    void updateUser(User user);
}
