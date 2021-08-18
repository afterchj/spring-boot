package com.example.demo.entity.model;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author hjchen
 * @since 2021-07-24
 */
@Data
@Entity
@Table(name = "core_dept")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Dept对象", description = "部门表")
public class Dept extends BaseEntity {

    @ApiModelProperty(value = "父部门id")
    private Long parentId;

    @ApiModelProperty(value = "祖级列表")
    private String ancestors;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "负责人")
    private String leader;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

}
