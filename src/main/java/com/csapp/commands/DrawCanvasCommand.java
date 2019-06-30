package com.csapp.commands;

import com.csapp.core.Canvas;
import com.csapp.exceptions.CanvasException;

public class DrawCanvasCommand extends Command {
    @Override
    public String getName() {
        return "c";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException {
        if (!this.validate(parameters)) {
            return -1;
        }
        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.CREATE) {
            System.out.println("Wrong parameters to create the canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validate(String[] parameters) {
        // check if it's null to avoid NullPointerException
        try {
            return validateParams(parameters) && validateLength(parameters) && validateTypes(parameters);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
