package com.spiritual.note.error;

import com.spiritual.note.error.exceptions.NotFoundExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*
* this notation used to tell all controllers to set in mind this class (Component).
* */
@ControllerAdvice
public class ApiExceptionHandler extends RuntimeException {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleException(ApiBaseException ex, WebRequest webRequest)
    {
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,ex.getStatusCode());
    }

}
