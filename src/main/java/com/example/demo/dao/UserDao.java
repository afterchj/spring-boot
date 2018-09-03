package com.example.demo.dao;

import com.example.demo.entity.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2018/9/3.
 */

@Mapper
public interface UserDao {

    List<UserVo> getAll();

    @Select("select * from t_user where id=#{id}")
    Map getById(int id);

//    @Select("select * from t_user")
    List<UserVo> getByPage();

    @Insert("insert into t_user(login_name,user_name,telephone,company,password,is_admin) values(#{loginName}, #{userName}, #{telephone}, #{company},#{password},#{isAdmin})")
    void insertUser(UserVo user);
}
