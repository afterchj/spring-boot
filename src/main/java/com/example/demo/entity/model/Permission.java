package com.example.demo.entity.model;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.MappedTypes;

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
@Table(name = "core_permission")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Permission对象", description = "")
public class Permission extends BaseEntity {

    private String name;

    private String code;

    private String remark;

    @ManyToMany(mappedBy = "perms")
    private Set<Role> roles;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
