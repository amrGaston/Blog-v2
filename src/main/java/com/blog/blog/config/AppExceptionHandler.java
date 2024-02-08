package com.blog.blog.config;

import com.blog.blog.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<ApiResponse> handleException(ComentarioNoEncontradoException e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), HttpStatus.NOT_FOUND ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestConErrorException.class)
    public ResponseEntity<ApiResponse> handleException(RequestConErrorException e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNoEncontradoException.class)
    public ResponseEntity<ApiResponse> handleException(PostNoEncontradoException e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<ApiResponse> handleException(UsuarioNoEncontradoException e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}

