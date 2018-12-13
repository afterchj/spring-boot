package com.example.demo.exception;

/**
 * Created by hongjian.chen on 2018/12/13.
 */
public class InvalidCodeException extends Exception {

    public InvalidCodeException() {
    }

    public InvalidCodeException(String message) {
        super(message);
    }
}
