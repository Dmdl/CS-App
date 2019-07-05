package com.csapp.commands;

import com.csapp.core.Canvas;
import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;
import com.csapp.util.Constant;

public abstract class Command {

    enum COMMANDS {
        CREATE(2),
        LINE(4),
        RECTANGLE(4),
        FILL(3),
        QUIT(0);

        private final int paramCount;

        COMMANDS(int paramCount) {
            this.paramCount = paramCount;
        }

        protected int getParamCount() {
            return paramCount;
        }
    }

    protected Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract String getName();

    public abstract void execute(String[] parameters) throws CanvasException, InvalidParameterException;

    public abstract void validateLength(String[] parameters) throws InvalidParameterException;

    public void validate(String[] parameters) throws InvalidParameterException, CanvasException {
        if (parameters == null) {
            throw new InvalidParameterException(Constant.MISSING_PARAMS);
        }
        if (this.canvas == null) {
            throw new CanvasException("You need to Create a Canvas first");
        }
        validateTypes(parameters);
        validateLength(parameters);
        validateRange(parameters);
    }

    public void validateTypes(String[] parameters) throws InvalidParameterException {
        for (String param : parameters) {
            if (!isInteger(param)) {
                throw new InvalidParameterException("Parameter (" + param + ") is not and integer");
            }
        }
    }

    protected static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    protected static void validateParams(String[] parameters) throws InvalidParameterException {
        if (parameters == null) {
            throw new InvalidParameterException(Constant.MISSING_PARAMS);
        }
    }

    public abstract void validateRange(String[] parameters) throws InvalidParameterException;
}
