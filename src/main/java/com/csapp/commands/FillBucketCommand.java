package com.csapp.commands;

import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;

public class FillBucketCommand extends Command {
    @Override
    public String getName() {
        return "b";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException,InvalidParameterException {
        if (!this.validate(parameters)) {
            return -1;
        }
        canvas.fillBucket(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2].charAt(0));
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) throws InvalidParameterException{
        if (parameters.length != COMMANDS.FILL.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters to Fill canvas, please check your command");
        }
        return true;
    }

    @Override
    public boolean validateTypes(String[] parameters) throws InvalidParameterException{
        for (int i = 0; i < parameters.length - 1; i++) {
            if (!isInteger(parameters[i])) {
                throw new InvalidParameterException("Parameter (" + parameters[i] + ") is not and integer");
            }
        }
        return true;
    }

    @Override
    public boolean validateRange(String[] parameters) throws InvalidParameterException {
        return true;
    }
}
