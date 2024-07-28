package com.epam.upskill.calculator.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> IllegalArgumentException(IllegalArgument exception){
        ResponseError errorResponse = new ResponseError(ErrorClass.BAD_REQUEST_ZERO_OPERAND, exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullArgument.class)
    public ResponseEntity<Object> handleNullArgumentException(NullArgument exception){
        ResponseError errorResponse = new ResponseError(ErrorClass.BAD_REQUEST_NULL_VALUE, exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
