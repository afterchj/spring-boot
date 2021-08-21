package com.example.demo.entity.model;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author hjchen
 * @since 2021-07-17
 */
@Data
@Entity
@Table(name = "core_user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User对象", description = "")
public class User extends BaseEntity {

    private String username;

    private String password;

    private String email;

    private String mobile;

    private String nickname;

    private String account;

    private String salt;

//    private Integer deptId;
//
//    private Integer postId;

    private String deptName;

    @ManyToMany
    @JoinTable(name = "core_user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

}
