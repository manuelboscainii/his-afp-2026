package com.sio.backend.exception;

import com.sio.backend.generics.ApiResponse;
import com.sio.backend.generics.ApiResponseStatus;
import com.sio.backend.resources.PathologiesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleAll(Exception ex) {
        return ApiResponse.builder()
                .status(ApiResponseStatus.ERROR)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .errorCode(ex.getMessage())
                .build();
    }

}
