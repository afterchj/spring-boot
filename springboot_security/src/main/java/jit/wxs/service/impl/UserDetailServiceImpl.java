package jit.wxs.service.impl;

import com.alibaba.fastjson.JSON;
import jit.wxs.dao.MenuDao;
import jit.wxs.dao.RoleDao;
import jit.wxs.dao.UserDao;
import jit.wxs.model.Menu;
import jit.wxs.model.Role;
import jit.wxs.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 获取用户相关信息
 *
 * @author hjchen
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.warn("username {}",username);
        // 根据用户名查找用户
        UserEntity user = userDao.getUserByUsername(username);
        logger.warn("user {}", JSON.toJSONString(user));
        if (user != null) {
            //根据用户id获取用户角色
            List<Role> roles = roleDao.getUserRoleByUserId(user.getId());
            // 填充权限
            Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            //填充权限菜单
            List<Menu> menus = menuDao.getRoleMenuByRoles(roles);
            return new UserEntity(username, user.getPassword(), authorities, menus);
        } else {
            logger.warn("{} not found", username);
            throw new UsernameNotFoundException(username + " not found");
        }
    }

}
