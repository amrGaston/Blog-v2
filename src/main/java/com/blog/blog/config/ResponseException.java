package com.blog.blog.config;

import com.blog.blog.exception.ComentarioNoEncontradoException;
import com.blog.blog.exception.RespuestaError;
import com.blog.blog.model.Comentario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleException(ComentarioNoEncontradoException e){
        return new ResponseEntity<>(new RespuestaError(e.getMessage(),HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }

}

