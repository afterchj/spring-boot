package jit.wxs.web;

import com.alibaba.fastjson.JSON;
import jit.wxs.entity.Msg;
import jit.wxs.entity.SysRole;
import jit.wxs.entity.SysUser;
import jit.wxs.entity.SysUserRole;
import jit.wxs.service.SysRoleService;
import jit.wxs.service.SysUserRoleService;
import jit.wxs.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jitwxs
 * @date 2018/3/30 1:30
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysUserRoleService userRoleService;

    @Autowired
    private SysRoleService roleService;

    @RequestMapping("/")
    public String showHome(Model model) {
        Map<String, String> map = new HashMap();
        map.put("extra", "额外信息，只对管理员显示");
        map.put("tip", "测试内容");
        Msg msg = new Msg(true, "测试标题", map);
        //Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

//    @RequestMapping("/error")
//    public String showError() {
//        return "error.html";
//    }

    @RequestMapping("/login/error")
    @ResponseBody
    public Msg<?> loginError(HttpServletRequest request) {
        AuthenticationException exception = (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");

        return new Msg<>(false, exception.getMessage(), exception.toString());
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public Object register(SysUser user, Integer[] roles) throws Exception {
        String name = user.getName();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(user.getPassword())) {
            throw new Exception("输入数据错误");
        }

        if (userService.selectByName(name) != null) {
            throw new Exception("用户名已被注册");
        }
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        String salt = BCrypt.gensalt();
        user.setPassword(BCrypt.hashpw(user.getPassword(), salt));
        user.setSalt(salt);
        userService.insert(user);
        int id = userService.selectByName(name).getId();
        for (Integer roleId : roles) {
            userRoleService.insert(id, roleId);
        }
        return "redirect:/login";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public Msg<?> getSelfUserInfo() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        SysUser user = userService.selectByName(name);
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        logger.warn("userRoles {}", JSON.toJSONString(userRoles));
        List<SysRole> roles = new ArrayList<>();
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            roles.add(role);
        }

        Map<String, Object> map = new HashMap<>(16);
        map.put("name", name);
        map.put("roles", roles);
        logger.warn("roles {}", JSON.toJSONString(roles));
        return new Msg<>(true, null, map);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseBody
    public String printTeacher() {
        return "如果你看见这句话，说明你有ROLE_TEACHER角色";
    }

    @GetMapping("/adminOrTeacher")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @ResponseBody
    public String printAdminAndTeacher() {
        return "如果你看见这句话，说明你有ROLE_ADMIN或ROLE_TEACHER和角色";
    }
}