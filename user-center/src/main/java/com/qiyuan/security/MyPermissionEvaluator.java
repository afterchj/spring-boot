package com.qiyuan.security;

import com.alibaba.fastjson.JSON;
import com.qiyuan.model.Menu;
import com.qiyuan.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname MyPermissionEvaluator
 * @Description TODO
 * @Date 2020/06/28 09:59
 * @Created by hjchen
 */
@Slf4j
@Configuration
public class MyPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean accessible = false;
//        if (authentication.getPrincipal().toString().compareToIgnoreCase("anonymousUser") != 0) {
        String privilege = targetDomainObject + "-" + permission;
        log.warn("permission {}", privilege);
        UserEntity u = (UserEntity) authentication.getPrincipal();
        List<Menu> menus = u.getRoleMenus();
        log.warn("menus {}", JSON.toJSONString(menus));
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String admin = authority.getAuthority();
            log.warn("authority {}", admin);
            if (StringUtils.endsWith("ROLE_ADMIN", admin)) {
                accessible = true;
                break;
            }
        }
//            return accessible;
//        }

        return accessible;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // TODO Auto-generated method stub
        return false;
    }

}
