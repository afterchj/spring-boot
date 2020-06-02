package jit.wxs.dao;


import jit.wxs.model.Role;

import java.util.List;
public interface RoleDao {
	/**
	 * 根据用户id获取用户
	 * @param id
	 * @return
	 */
	List<Role> getUserRoleByUserId(Long id);

}
