package com.blog.blog.exception;

public class PostNoEncontradoException extends GenericException{

    public PostNoEncontradoException(Long id){
        super("Post NO encontrado con id: " + id);
    }
}
