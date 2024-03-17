package com.neuron.library_api.controller;

import com.neuron.library_api.dto.response.CommonResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CommonResponse<?>> dataIntegrityViolationException(DataIntegrityViolationException e){
        CommonResponse.CommonResponseBuilder<Object> builder = CommonResponse.builder();
        HttpStatus httpStatus;

        if(e.getMessage().contains("foreign key constraint")){
            builder.statusCode(HttpStatus.BAD_REQUEST.value())
                    .message("cant save data because book or member is not present");
            httpStatus  = HttpStatus.BAD_REQUEST;
        }else if(e.getMessage().contains("unique constraint") || e.getMessage().contains("already exist")){
            builder.statusCode(HttpStatus.CONFLICT.value())
                    .message("data already exist");
            httpStatus = HttpStatus.CONFLICT;
        }else{
            builder.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("Internal sever error");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());
    }
}
