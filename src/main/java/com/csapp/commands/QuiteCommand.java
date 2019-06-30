package com.csapp.commands;

import com.csapp.exceptions.CanvasException;

public class QuiteCommand extends Command{
    @Override
    public String getName() {
        return "q";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException {
        if (this.validateLength(parameters)) {
            System.out.println("Exit...");
            System.exit(0);
        }
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.QUIT){
            System.out.println("Wrong parameters!");
            return false;
        }
        return true;
    }
}
