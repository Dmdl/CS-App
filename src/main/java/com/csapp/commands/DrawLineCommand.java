package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.shapes.Line;
import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;

public class DrawLineCommand extends Command {
    @Override
    public String getName() {
        return "l";
    }

    @Override
    public int execute(String[] parameters) throws InvalidParameterException, CanvasException {
        if (!this.validate(parameters)) {
            return -1;
        }
        Point p1 = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Point p2 = new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
        Shape line = new Line(p1, p2);
        line.addToCanvas(this.canvas);
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.LINE.getParamCount()) {
            throw new InvalidParameterException("Wrong parameters to draw a line, please check your command");
        }
        return true;
    }

    @Override
    public boolean validateRange(String[] parameters) throws InvalidParameterException {
        int x1 = Integer.parseInt(parameters[0]);
        int y1 = Integer.parseInt(parameters[1]);
        int x2 = Integer.parseInt(parameters[2]);
        int y2 = Integer.parseInt(parameters[3]);
        if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
            throw new InvalidParameterException("Parameters can't be less than 0");
        if (x2 < x1 || y2 < y1)
            throw new InvalidParameterException("Parameters must be x2>x1 and y2>y1");
        if (x2 > this.canvas.getWidth() || y2 > this.canvas.getHeight())
            throw new InvalidParameterException("Must draw within the Canvas");
        return true;
    }
}
