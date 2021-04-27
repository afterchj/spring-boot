package com.isoft.after.constants;

import lombok.Getter;

/**
 * @author xxy
 * @version $Id: CommonCodeEnum.java
 */
@Getter
public enum CommonCodeEnum implements IResultEnum {

    /**
     * 操作成功
     */
    SUCCESS(200, "成功"),
    FORBIDDEN(403, "没有权限"),


    /**
     * 系统错误
     */
    SYSTEM_FAILURE(500, "系统错误"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(500, "系统异常！"),

    /**
     * 参数为空
     */
    NULL_ARGUMENT(1002, "参数为空"),

    /**
     * 参数不正确
     */
    ILLEGAL_ARGUMENT(1003, "参数不正确"),

    ;

    /**
     * 错误码
     */
    protected int value;
    /**
     * 描述信息
     */
    protected String message;

    /**
     * 构造方法
     */
    CommonCodeEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code 错误码
     * @return
     */
    public static CommonCodeEnum getEnumByCode(int code) {
        for (CommonCodeEnum param : values()) {
            if (code == param.value()) {
                return param;
            }
        }
        return SUCCESS;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public int value() {
        return value;
    }

}
