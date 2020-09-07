package com.spiritual.note.error.exceptions;

import com.spiritual.note.error.ApiBaseException;
import org.springframework.http.HttpStatus;

public class NotFoundExceptionHandler extends ApiBaseException {

    public NotFoundExceptionHandler(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode()
    {
        return HttpStatus.NOT_FOUND;
    }
}
