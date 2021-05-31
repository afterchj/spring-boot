//package com.example.demo.service;
//
//import com.alibaba.fastjson.JSON;
//import com.example.demo.dao.SysUserRepository;
//import com.example.demo.entity.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//
//public class CustomUserService implements UserDetailsService { //1
//    @Autowired
//    private SysUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) { //2
//
//        SysUser user = userRepository.findByUsername(username);
//        System.out.println("user="+JSON.toJSONString(user));
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        return user; //3
//    }
//
//}
