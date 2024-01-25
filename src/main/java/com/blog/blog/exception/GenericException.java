package com.blog.blog.exception;

public abstract class GenericException extends Exception{


    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }
}
