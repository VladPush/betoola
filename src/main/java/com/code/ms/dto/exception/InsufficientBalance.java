package com.code.ms.dto.exception;

import org.springframework.http.HttpStatus;

public class InsufficientBalance extends JsonExceptionResponse {

    public InsufficientBalance(String messageParam) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Balance problems", messageParam);
    }
}
