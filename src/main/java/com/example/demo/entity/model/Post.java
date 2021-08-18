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
 * 岗位信息表
 * </p>
 *
 * @author hjchen
 * @since 2021-07-24
 */
@Data
@Entity
@Table(name ="core_post")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Post对象", description="岗位信息表")
public class Post extends BaseEntity {

    @ApiModelProperty(value = "岗位编码")
    private String jobCode;

    @ApiModelProperty(value = "岗位名称")
    private String jobTitle;

    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;


}
