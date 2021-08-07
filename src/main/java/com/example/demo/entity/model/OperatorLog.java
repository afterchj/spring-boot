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
 * 操作日志记录
 * </p>
 *
 * @author hjchen
 * @since 2021-07-17
 */
@Data
@Entity
@Table(name = "sys_operator_log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OperatorLog对象", description = "操作日志记录")
public class OperatorLog extends BaseEntity {

    @ApiModelProperty(value = "主机地址")
    private String ip;

    @ApiModelProperty(value = "操作地点")
    private String ipAddr;

    @ApiModelProperty(value = "业务类型")
    private Integer businessType;

    @ApiModelProperty(value = "方法名称")
    private String method;

    @ApiModelProperty(value = "操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operType;

    @ApiModelProperty(value = "请求URL")
    private String operUrl;

    @ApiModelProperty(value = "操作内容")
    private String content;

    @ApiModelProperty(value = "返回状态码")
    private Integer code;

}
