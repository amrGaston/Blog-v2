package com.blog.blog.exception;

public class UsuarioNoEncontradoException extends GenericException{

    public UsuarioNoEncontradoException(Long id){
        super("Usuario no encontrado con ID: " + id );
    }
}
