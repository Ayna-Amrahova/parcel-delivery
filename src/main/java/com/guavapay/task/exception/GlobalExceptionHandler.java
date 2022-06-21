package com.guavapay.task.exception;

import com.guavapay.task.dto.BaseResponse;
import com.guavapay.task.enums.ErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.guavapay.task.dto.BaseResponse.of;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<BaseResponse<Object>> handleRestException(RestException restException) {
        restException.printStackTrace();
        return ResponseEntity
                .status(restException.getStatus())
                .body(of(restException));
    }

}
