package com.code.ms.controller;


import com.code.ms.dto.exception.JsonExceptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
@Order
@RequiredArgsConstructor
public class ExceptionsController {

    @ExceptionHandler(value = JsonExceptionResponse.class)
    public JsonExceptionResponse jsonExceptionResponse(@NonNull final JsonExceptionResponse e,
                                                       @NonNull final HttpServletResponse httpServletResponse) {
        return e;
    }


}

