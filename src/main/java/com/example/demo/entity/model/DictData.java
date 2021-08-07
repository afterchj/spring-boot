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
 * 字典数据表
 * </p>
 *
 * @author hjchen
 * @since 2021-07-18
 */
@Data
@Entity
@Table(name ="core_dict_data")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="DictData对象", description="字典数据表")
public class DictData extends BaseEntity {

    @ApiModelProperty(value = "字典排序")
    private Integer dictSort;

    @ApiModelProperty(value = "字典标签")
    private String dictLabel;

    @ApiModelProperty(value = "字典键值")
    private String dictValue;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "样式属性（其他样式扩展）")
    private String cssClass;

    @ApiModelProperty(value = "表格回显样式")
    private String listClass;

    @ApiModelProperty(value = "是否默认（Y是 N否）")
    private String isDefault;

    @ApiModelProperty(value = "备注")
    private String remark;


}
