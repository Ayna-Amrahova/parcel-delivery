package com.guavapay.task.dto;

import com.guavapay.task.enums.ErrorEnum;
import com.guavapay.task.exception.RestException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BaseResponse<T> implements Serializable {

    public enum ResponseType {
        SUCCESS, ERROR
    }

    private static final long serialVersionUID = 1L;
    private Long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC); // todo
    private String messageType;
    private String message;
    private Integer code;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(ResponseType type, String message, Integer code) {
        this.messageType = type.name();
        this.message = message;
        this.code = code;
    }

    public BaseResponse(ResponseType type, T data) {
        this.messageType = type.name();
        this.data = data;
    }

    public BaseResponse(ResponseType type, String message, Integer code, T data) {
        this.messageType = type.name();
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static BaseResponse<Object> of(RestException restException) {
        return new BaseResponse<>(ResponseType.ERROR, restException.getMessage(), restException.getCode());
    }

    public static BaseResponse<Object> of(Exception e) {
        return new BaseResponse<>(ResponseType.ERROR, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static BaseResponse<Object> of(ErrorEnum error) {
        return new BaseResponse<>(ResponseType.ERROR, error.getMessage(), error.getCode());
    }

    public static <T> BaseResponse<T> success(T object) {
        return new BaseResponse<>(ResponseType.SUCCESS, "Successfully", 200, object);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public BaseResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public BaseResponse<T> setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "timestamp=" + timestamp +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
