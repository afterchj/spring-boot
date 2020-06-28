package com.qiyuan.service;


import com.qiyuan.model.UserEntity;
import com.qiyuan.model.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(UserEntity user);

	List<Map> getAll();

}
