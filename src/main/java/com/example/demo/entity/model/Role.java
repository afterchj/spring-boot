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
 * @since 2021-07-18
 */
@Data
@Entity
@Table(name = "core_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Role对象", description = "")
public class Role extends BaseEntity {

    private String name;

    private String code;

    private String remark;

    @ManyToMany
    @JoinTable(name = "core_role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "perm_id", referencedColumnName = "id")})
    private Set<Permission> perms;

    @ManyToMany
    @JoinTable(name = "core_role_menu", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<Menu> menus;

}
