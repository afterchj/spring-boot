package com.isoft.after.constants;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Classname Result
 * @Description TODO
 * @Date 2021/3/9 17:07
 * @Created by hjchen
 */

@Data
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    private Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

    public Result() {
    }

    public Result(IResultEnum resultEnum) {
        this.msg = resultEnum.message();
        this.code = resultEnum.value();
    }

    public Result(IResultEnum resultEnum, T data) {
        this.msg = resultEnum.message();
        this.code = resultEnum.value();
        this.data = data;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(int code, String msg, T data, Long time) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = time;
    }

    /**
     * @param code
     */
    public Result(int code) {
        this.code = code;
    }

    /**
     * @param code
     * @param msg
     */
    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code
     * @param msg
     * @param data
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}