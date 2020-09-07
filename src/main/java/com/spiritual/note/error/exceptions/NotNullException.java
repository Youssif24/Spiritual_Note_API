package com.spiritual.note.error.exceptions;

import com.spiritual.note.error.ApiBaseException;
import org.springframework.http.HttpStatus;

public class NotNullException extends ApiBaseException {
    public NotNullException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.FORBIDDEN;
    }
}
