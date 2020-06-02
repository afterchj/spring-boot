package jit.wxs.service;


import jit.wxs.model.UserEntity;

public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(UserEntity user);

}
