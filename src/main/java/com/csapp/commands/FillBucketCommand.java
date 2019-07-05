package com.csapp.commands;

import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;

public class FillBucketCommand extends Command {
    @Override
    public String getName() {
        return "b";
    }

    @Override
    public void execute(String[] parameters) throws CanvasException, InvalidParameterException {
        this.validate(parameters);
        canvas.fillBucket(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2].charAt(0));
        canvas.draw();
    }

    @Override
    public void validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.FILL.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters to Fill canvas, please check your command");
        }
    }

    @Override
    public void validateTypes(String[] parameters) throws InvalidParameterException {
        for (int i = 0; i < parameters.length - 1; i++) {
            if (!isInteger(parameters[i])) {
                throw new InvalidParameterException("Parameter (" + parameters[i] + ") is not and integer");
            }
        }
    }

    @Override
    public void validateRange(String[] parameters) throws InvalidParameterException {
        int x = Integer.parseInt(parameters[0]);
        int y = Integer.parseInt(parameters[1]);
        if (x < 0 || y < 0 || x > this.canvas.getWidth() || y > this.canvas.getHeight())
            throw new InvalidParameterException("Parameters are out of canvas");
    }
}
