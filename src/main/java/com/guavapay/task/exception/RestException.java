package com.guavapay.task.exception;


import com.guavapay.task.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class RestException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HttpStatus status;
    private final Integer code;
    private final String message;

    public RestException(ErrorEnum errorEnum) {
        this.status = errorEnum.getStatus();
        this.code = errorEnum.getCode();
        this.message = errorEnum.getMessage();
    }

    public static RestException of(ErrorEnum error) {
        return new RestException(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void throwEx() {
        throw this;
    }
}
