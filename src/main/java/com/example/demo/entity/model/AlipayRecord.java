package com.example.demo.entity.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjchen
 * @since 2021-07-17
 */
@Data
@Entity
@Table(name ="sys_alipay_record")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AlipayRecord对象", description="")
public class AlipayRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String tradeSources;

    private String tradeDescription;

    private String counterparty;

    private String shopName;

    private Double money;

    private String tradeType;

    private String tradeStatus;

    private String notes;

    private String moneyChange;


}
