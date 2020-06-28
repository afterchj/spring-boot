package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hongjian.chen on 2019/6/12.
 */
@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity {
    private String name;
    private int age;
}
