package com.spiritual.note.error.exceptions;

import com.spiritual.note.error.ApiBaseException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseException {
    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }


}
