package com.epam.upskill.calculator.ErrorCode;

public enum ErrorCode {
    INVALID_ARGUMENT(400, "Invalid input provided"),
    SUCCESSFUL_OPERATION(200, "Successful"),
    SERVER_ERROR(500, "Server error"),
    AUTHENTICATION_ERROR(401, "Authentication error");


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
