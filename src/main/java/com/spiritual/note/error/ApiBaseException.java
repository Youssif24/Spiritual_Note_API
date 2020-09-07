package com.spiritual.note.error;

import org.springframework.http.HttpStatus;

/*
* every exception class i'm gonna do, extend this class
* so it will implement it's constructor and getStatusCode method (Abstraction)
* */
public abstract class ApiBaseException extends RuntimeException {

    public ApiBaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
