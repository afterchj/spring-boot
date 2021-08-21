package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: hjchen
 * @Contact: afterchj@foxmail.com
 * @Date: 2020/12/21 13:49
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    @ApiModelProperty(value = "创建者")
    private Long createBy;


    @ApiModelProperty(value = "更新者")
    private Long updateBy;


    @ApiModelProperty(value = "部门状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private Integer isDeleted;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime = LocalDateTime.now();

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime = LocalDateTime.now();

}
