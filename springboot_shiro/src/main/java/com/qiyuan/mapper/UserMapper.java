package com.qiyuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qiyuan.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jitwxs
 * @since 2018-03-20
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(id,name,password,create_date,salt,status) VALUES(#{id},#{name},#{password},CURDATE(),'abc',1)")
    void insertUser(User user);

    @Update("UPDATE user SET name=#{name},password=#{password},modified_date=NOW() WHERE id=#{id}")
    void updateUser(User user);

}
