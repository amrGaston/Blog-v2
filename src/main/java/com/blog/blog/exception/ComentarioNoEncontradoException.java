package com.blog.blog.exception;

public class ComentarioNoEncontradoException extends GenericException{

    public ComentarioNoEncontradoException( Long id) {
        super( "Comentario NO encontrado con id: " + id);
    }

}
