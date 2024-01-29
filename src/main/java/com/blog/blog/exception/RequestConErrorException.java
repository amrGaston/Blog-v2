package com.blog.blog.exception;

public class RequestConErrorException extends GenericException{

    public RequestConErrorException(){
        super("Parametros incorrectos en el request");
    }
}
