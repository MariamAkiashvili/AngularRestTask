package com.epam.upskill.calculator.exceptionHandler;

public class IllegalArgument extends Exception{
    public IllegalArgument(){
    }

    public IllegalArgument(String message) {
        super(message);
    }

    public IllegalArgument(String message, Exception exception) {
        super(message, exception);
    }

    public IllegalArgument(Exception exception) {
        super(exception);
    }
}
