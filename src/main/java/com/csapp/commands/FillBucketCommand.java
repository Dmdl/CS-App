package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.exceptions.CanvasException;

public class FillBucketCommand extends Command {
    @Override
    public String getName() {
        return "b";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException {
        if (!this.validate(parameters)) {
            return -1;
        }
        Point p = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.fillBucket(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]), parameters[2].charAt(0));
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.FILL) {
            System.out.println("Wrong parameters to Fill canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTypes(String[] parameters) {
        for (int i = 0; i < parameters.length - 1; i++) {
            if (!isInteger(parameters[i])) {
                System.out.println("Parameter (" + parameters[i] + ") is not and integer");
                return false;
            }
        }
        return true;
    }
}
