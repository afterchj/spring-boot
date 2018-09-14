//package com.example.demo;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////@Configuration
////@EnableWebSecurity  //可以不需要这个注解
//public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/","/css", "/login", "/page", "/userList").permitAll()//1根路径和/login路径不拦截
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") //2登陆页面
//                .defaultSuccessUrl("/chat") //3登陆成功转向该页面
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    //4
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("wyf")
//                .password(new BCryptPasswordEncoder().encode("wyf")).roles("USER")
//                .and()
//                .withUser("wisely")
//                .password(new BCryptPasswordEncoder().encode("wisely")).roles("USER");
////        auth
////                .inMemoryAuthentication()
////                .withUser("wyf").password("wyf").roles("USER")
////                .and()
////                .withUser("wisely").password("wisely").roles("USER");
//    }
//
//    //5忽略静态资源的拦截
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/static/**");
//    }
//
//}