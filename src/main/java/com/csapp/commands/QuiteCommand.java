package com.csapp.commands;

import com.csapp.exceptions.InvalidParameterException;
import com.csapp.exceptions.QuiteDrawingException;

public class QuiteCommand extends Command {
    @Override
    public String getName() {
        return "q";
    }

    @Override
    public int execute(String[] parameters) throws InvalidParameterException {
        if (this.validateLength(parameters)) {
            throw new QuiteDrawingException("Exiting");
        }
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.QUIT.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters!");
        }
        return true;
    }

    @Override
    public boolean validateRange(String[] parameters) {
        return true;
    }
}
