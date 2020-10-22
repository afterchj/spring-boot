package com.qiyuan.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qiyuan.entity.*;
import com.qiyuan.service.*;
import com.qiyuan.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jitwxs
 * @date 2018/3/20 9:35
 */

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IPermissionService permissionService;

    @Autowired
    IRolePermissionService rolePermissionService;

    @Autowired
    HashedCredentialsMatcher hashedCredentialsMatcher;

    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info;
        // 获取用户名和密码
        String name = token.getPrincipal().toString();
//        String password = new String((char[]) token.getCredentials());
        User user = userService.findByName(name);
        log.warn("user {}", user);
        String credentials = user.getPassword();
        if (user != null) {
            ByteSource salt = ByteSource.Util.bytes(user.getSalt());
            log.warn("salt {}", salt);
            //验证authenticationToken和simpleAuthenticationInfo的信息
            info = new SimpleAuthenticationInfo(name, credentials, salt, getName());
        } else {
            throw new AuthenticationException();
        }
        // 返回一个身份信息
        return info;
    }

    /**
     * 角色权限和对应权限添加
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        // 获取用户对象
        User user = userService.findByName(name);
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<Role> roles = getRoles(user.getId());

        for (Role role : roles) {
            // 添加角色
            simpleAuthorizationInfo.addRole(role.getName());

            // 添加权限
            List<Permission> permissions = getPermission(role.getId());
            for (Permission permission : permissions) {
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }


    private List<Role> getRoles(String userId) {
        List<UserRole> userRoles = userRoleService.selectList(new EntityWrapper<UserRole>().eq("user_id", userId));
        List<Role> list = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            Role role = roleService.selectById(userRole.getRoleId());
            list.add(role);
        }
        return list;
    }

    private List<Permission> getPermission(String roleId) {
        List<RolePermission> rolePermissions = rolePermissionService.selectList(new EntityWrapper<RolePermission>().eq("role_id", roleId));

        List<Permission> list = new ArrayList<>();

        for (RolePermission rolePermission : rolePermissions) {
            Permission permission = permissionService.selectById(rolePermission.getPermissionId());
            list.add(permission);
        }
        return list;
    }
}
