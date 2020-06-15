package jit.wxs.service.impl;

import jit.wxs.dao.UserDao;
import jit.wxs.model.UserEntity;
import jit.wxs.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	/**
	 * 保存用户
	 */
	@Override
	public void saveUser(UserEntity user) {
		userDao.insertUser(user);
	}

	@Override
	public List<Map> getAll() {
		return userDao.getAll();
	}

}
