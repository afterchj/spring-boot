package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2020/6/12 17:15
 * @Created by hjchen
 */

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "datetime default now()")
    private Date createTime=new Date();
    @Column(columnDefinition = "datetime default now()")
    private Date updateTime =new Date();
}
