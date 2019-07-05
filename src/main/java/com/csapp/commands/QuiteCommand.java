package com.csapp.commands;

import com.csapp.exceptions.InvalidParameterException;
import com.csapp.exceptions.QuiteDrawingException;

public class QuiteCommand extends Command {
    @Override
    public String getName() {
        return "q";
    }

    @Override
    public void execute(String[] parameters) {
        throw new QuiteDrawingException("Exiting ...");
    }

    @Override
    public void validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.QUIT.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters!");
        }
    }

    @Override
    public void validateRange(String[] parameters) {
    }
}
