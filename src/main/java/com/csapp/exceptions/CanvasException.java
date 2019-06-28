package com.csapp.exceptions;

public class CanvasException extends Exception {
    public CanvasException() {
        super();
    }

    public CanvasException(String msg) {
        super(msg);
    }

    public CanvasException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
