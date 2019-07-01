package com.csapp.commands;

import com.csapp.exceptions.InvalidParameterException;

public class QuiteCommand extends Command {
    @Override
    public String getName() {
        return "q";
    }

    @Override
    public int execute(String[] parameters) throws InvalidParameterException {
        if (this.validateLength(parameters)) {
            System.out.println("Exit...");
            System.exit(0);
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
}
