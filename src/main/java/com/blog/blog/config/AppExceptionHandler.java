package com.blog.blog.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import com.blog.blog.exception.ComentarioNoEncontradoException;
import com.blog.blog.exception.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<ApiResponse> handleException(ComentarioNoEncontradoException e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(),e.getEstado().value()),e.getEstado());
    }



}

