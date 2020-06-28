package com.example.demo.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2020/6/19 16:50
 * @Created by hjchen
 */
@Data
@Entity
@Table(name = "t_student")
public class Student extends BaseEntity implements Serializable{

    @Column(length = 32)
    private String name;

    private Integer age;

    // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    private BasClass clazz;

}
