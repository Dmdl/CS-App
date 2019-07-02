package com.csapp.commands;

import com.csapp.core.Canvas;
import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;

public class DrawCanvasCommand extends Command {
    @Override
    public String getName() {
        return "c";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException, InvalidParameterException {
        if (!this.validate(parameters)) {
            return -1;
        }
        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.CREATE.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters to create the canvas, please check your command");
        }
        return true;
    }

    @Override
    public boolean validate(String[] parameters) throws InvalidParameterException {
//        if (null == parameters)
//            throw new InvalidParameterException("parameters can't be null");
        return validateLength(parameters) && validateTypes(parameters) && validateRange(parameters);
    }

    @Override
    public boolean validateRange(String[] parameters) throws InvalidParameterException {
        if (Integer.parseInt(parameters[0]) <= 0)
            throw new InvalidParameterException("Width must be greater than 0");
        if (Integer.parseInt(parameters[1]) <= 0)
            throw new InvalidParameterException("Height must be greater than 0");
        return true;
    }
}
