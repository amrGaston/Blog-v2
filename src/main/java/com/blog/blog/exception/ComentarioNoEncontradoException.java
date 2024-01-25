package com.blog.blog.exception;

import org.springframework.http.HttpStatus;

public class ComentarioNoEncontradoException extends GenericException{

    private HttpStatus estado;
    public ComentarioNoEncontradoException( Long id, HttpStatus estado) {
        super( "Comentario NO encontrado con id: " + id);
        this.estado = estado;
    }

    public HttpStatus getEstado() {
        return estado;
    }
}
