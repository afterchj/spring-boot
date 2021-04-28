package com.isoft.after.exception;

import com.isoft.after.constants.IResultEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private int code;
    private IResultEnum resultEnum;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(IResultEnum resultEnum) {
        super(resultEnum.message());
        this.code = resultEnum.value();
        this.resultEnum = resultEnum;
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }
}
