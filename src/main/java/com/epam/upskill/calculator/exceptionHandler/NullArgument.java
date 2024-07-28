package com.epam.upskill.calculator.exceptionHandler;

public class NullArgument extends Exception{
    public NullArgument(){
    }

    public NullArgument(String message) {
        super(message);
    }

    public NullArgument(String message, Exception exception) {
        super(message, exception);
    }

    public NullArgument(Exception exception) {
        super(exception);
    }
}
