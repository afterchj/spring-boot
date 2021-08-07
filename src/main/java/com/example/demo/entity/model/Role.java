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

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "perm_id", referencedColumnName = "id")})
    private Set<Permission> perms;

}
