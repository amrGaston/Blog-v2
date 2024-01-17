package com.blog.blog.exception;

import com.blog.blog.model.Comentario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<Comentario> recursoNoEncontrado(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

