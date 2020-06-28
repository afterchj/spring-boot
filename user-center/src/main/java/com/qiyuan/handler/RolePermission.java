package com.qiyuan.handler;

import com.qiyuan.model.Menu;
import com.qiyuan.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * RBAC数据模型控制权限
 *
 * @author hjchen
 */
@Component("rolePermission")
public class RolePermission {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        String url = request.getRequestURI();
        logger.warn("requestUrl {}", url);
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserEntity) {
            // 读取用户所拥有的权限菜单
            List<Menu> menus = ((UserEntity) principal).getRoleMenus();
            for (Menu menu : menus) {
                if (antPathMatcher.match(menu.getMenuUrl(), url)) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
