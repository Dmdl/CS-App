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
    public void execute(String[] parameters) throws CanvasException, InvalidParameterException {
        this.validate(parameters);
        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.draw();
    }

    @Override
    public void validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.CREATE.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters to create the canvas, please check your command");
        }
    }

    @Override
    public void validate(String[] parameters) throws InvalidParameterException {
        validateLength(parameters);
        validateTypes(parameters);
        validateRange(parameters);
    }

    @Override
    public void validateRange(String[] parameters) throws InvalidParameterException {
        if (Integer.parseInt(parameters[0]) <= 0)
            throw new InvalidParameterException("Width must be greater than 0");
        if (Integer.parseInt(parameters[1]) <= 0)
            throw new InvalidParameterException("Height must be greater than 0");
    }
}
