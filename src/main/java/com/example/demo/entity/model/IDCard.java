package com.example.demo.entity.model;

import com.example.demo.entity.BaseEntity;
import lombok.Data;
import javax.persistence.*;

/**
 * Created by hongjian.chen on 2018/3/14.
 */


@Data
@Entity
@Table(name = "sys_id_card")
public class IDCard extends BaseEntity {

    private String no;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private User user;

}
