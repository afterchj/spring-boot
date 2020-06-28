package com.qiyuan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qiyuan.entity.User;
import com.qiyuan.mapper.UserMapper;
import com.qiyuan.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jitwxs
 * @since 2018-03-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findByName(String name) {
        return baseMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public void insertUser(User user) {
        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes("abc");
        String newPs = new SimpleHash("MD5", user.getPassword(), salt, 2).toHex();
        user.setPassword(newPs);
        user.setSalt("abc");
        baseMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        ByteSource salt = ByteSource.Util.bytes("abc");
        String newPs = new SimpleHash("MD5", user.getPassword(), salt, 2).toHex();
        user.setPassword(newPs);
        user.setSalt("abc");
        baseMapper.updateUser(user);
    }
}

