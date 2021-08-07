package com.example.demo.entity.model;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author hjchen
 * @since 2021-07-18
 */
@Data
@Entity
@Table(name ="core_dict_type")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="DictType对象", description="字典类型表")
public class DictType extends BaseEntity {

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "备注")
    private String remark;


}
