package com.csapp.exceptions;

public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String msg) {
        super(msg);
    }

    public InvalidParameterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
