package com.isoft.after.utils;


import com.isoft.after.constants.CommonCodeEnum;
import com.isoft.after.constants.IResultEnum;
import com.isoft.after.constants.Result;

/**
 * @Classname ResponseUtil
 * @Description TODO
 * @Date 2021/3/9 17:04
 * @Created by hjchen
 */
public class ResponseUtil {


    public static final int SUCCESS = 200;
    public static final int ERROR = 400;
    public static final int FORBID = 403;
    public static final int STATUS = 301;

    /**
     * 成功
     *
     * @return
     */
    public static <T> Result<T> SUCCESS() {
        return new Result<T>(SUCCESS);
    }

    public static <T> Result<T> SUCCESS(T data) {
        return new Result<T>(CommonCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> SUCCESS(String message) {
        return new Result<T>(SUCCESS, message);
    }

    public static <T> Result<T> SUCCESS(String message, T data) {
        return new Result<T>(SUCCESS, message, data);
    }

    public static <T> Result<T> SUCCESS(IResultEnum message) {
        return SUCCESS(message);
    }

    public static <T> Result<T> SUCCESS(IResultEnum message, T data) {
        return new Result<T>(message, data);
    }

    /**
     * 失败
     *
     * @return
     */
    public static <T> Result<T> Failure() {
        return new Result<T>(ERROR);
    }

    public static <T> Result<T> Failure(int code, String message) {
        return new Result<T>(code, message);
    }

    public static <T> Result<T> Failure(String message) {
        return new Result<T>(ERROR, message);
    }

    public static <T> Result<T> Failure(String message, T data) {
        return new Result<T>(ERROR, message, data);
    }

    public static <T> Result<T> Failure(IResultEnum message) {
        return new Result<>(message);
    }

    public static <T> Result<T> Failure(IResultEnum message, T data) {
        return new <T>Result<T>(message, data);
    }

    public static <T> Result<T> Forbidden(String message) {
        return new Result<T>(FORBID, message);
    }

    /**
     * 消息提示
     */
    public static <T> Result<T> MESSAGE(String message) {
        return new Result<T>(STATUS, message);
    }

    public static <T> Result<T> MESSAGE(String message, T data) {
        return new Result<T>(STATUS, message, data);
    }

}