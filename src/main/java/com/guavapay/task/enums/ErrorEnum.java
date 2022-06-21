package com.guavapay.task.enums;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 999, "Unknown Server Error"),
    REQUEST_BODY_IS_MISSING(HttpStatus.INTERNAL_SERVER_ERROR, 998, "Request body is missing"),
    USERNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, 100, "Username already exists"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, 101, "User not found"),
    PASSWORD_MISMATCH(HttpStatus.CONFLICT, 102, "Passwords don't match"),
    PASSWORD_IS_WEAK(HttpStatus.BAD_REQUEST, 103, "Password must contains /bla bla bla/ symbols"),
    USER_ACCOUNT_DISABLED(HttpStatus.FORBIDDEN, 104, "Your account is disabled"),
    USERNAME_INVALID(HttpStatus.BAD_REQUEST, 105, "Username incorrect"),
    PASSWORD_INVALID(HttpStatus.BAD_REQUEST, 106, "Password incorrect"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.FORBIDDEN, 107, "Access token expired"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.FORBIDDEN, 108, "Refresh token expired"),
    AUTHENTICATION_INVALID(HttpStatus.BAD_REQUEST, 112, "Authentication error"),
    PARCEL_NOT_FOUND(HttpStatus.NOT_FOUND, 114, "Parcel not found"),
    DELIVERY_NOT_FOUND(HttpStatus.NOT_FOUND, 114, "Delivery not found");

    private final HttpStatus status;
    private final Integer code;
    private final String message;

    ErrorEnum(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorEnum getByCode(Integer code) {
        for (ErrorEnum error : values()) {
            if (error.getCode().equals(code)) {
                return error;
            }
        }
        return UNKNOWN_ERROR;
    }
}
