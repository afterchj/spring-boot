//package com.example.demo;
//
//import com.example.demo.service.CustomUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity  //可以不需要这个注解
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//1
//
//    @Bean
//    public UserDetailsService customUserService() { //2
//        return new CustomUserService();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder()); //3
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/register", "/registry", "/toLogin", "/page", "/userList").permitAll()//1根路径和/login路径不拦截
//                .anyRequest().authenticated() //4
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/show")  //登录成功后默认跳转到"show"
//                .permitAll() //5
//                .and()
//                .logout().permitAll(); //6
//
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //解决静态资源被拦截的问题
//        web.ignoring().antMatchers("/static/**");
//    }
//}
