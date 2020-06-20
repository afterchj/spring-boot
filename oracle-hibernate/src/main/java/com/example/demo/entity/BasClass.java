package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * @Classname BasClass
 * @Description TODO
 * @Date 2020/6/19 17:01
 * @Created by hjchen
 */
@Data
@Entity
@Table(name = "t_class")
public class BasClass extends BaseEntity {
    @Column(length = 32)
    private String name;
    // @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    // mappedBy="basClass": 指明BasClass类为双向关系维护端，负责外键的更新
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clazz")
    private List<Student> students;

}
