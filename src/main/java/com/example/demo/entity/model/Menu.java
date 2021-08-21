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
 * 菜单权限表
 * </p>
 *
 * @author hjchen
 * @since 2021-07-17
 */
@Data
@Entity
@Table(name = "core_menu")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Menu对象", description = "菜单权限表")
public class Menu extends BaseEntity {

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "组件路径")
    private String component;

    @ApiModelProperty(value = "是否为外链（0是 1否）")
    private Integer isFrame;

    @ApiModelProperty(value = "是否缓存（0缓存 1不缓存）")
    private Integer isCache;

    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    @ApiModelProperty(value = "菜单状态（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "备注")
    private String remark;


}
