package com.qiyuan.dao;

import com.qiyuan.model.Menu;
import com.qiyuan.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface MenuDao {

	/**
	 * 根据角色获取菜单列表
	 * @param roles
	 * @return
	 */
	List<Menu> getRoleMenuByRoles(@Param("roles") List<Role> roles);

}
