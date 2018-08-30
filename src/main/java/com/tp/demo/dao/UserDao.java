package com.tp.demo.dao;

import com.tp.demo.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hongjian.chen on 2018/8/24.
 */


public interface UserDao {

//    @Select("SELECT * FROM t_user")
    List<User> getAll();
}
