package com.epam.upskill.calculator.exceptionHandler;

public class ResponseError {
    private String code;
    private String message;

    public ResponseError(String code, String message){
        this.code = code;
        this.message = message;
    }
}
