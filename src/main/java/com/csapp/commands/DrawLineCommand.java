package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.shapes.Line;
import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;
import com.csapp.util.CanvasUtility;
import com.csapp.util.Constant;

public class DrawLineCommand extends Command {
    @Override
    public String getName() {
        return "l";
    }

    @Override
    public void execute(String[] parameters) throws InvalidParameterException, CanvasException {
        this.validate(parameters);
        Point p1 = CanvasUtility.createPoint(parameters[0], parameters[1]);
        Point p2 = CanvasUtility.createPoint(parameters[2], parameters[3]);
        Shape line = new Line(p1, p2);
        line.addToCanvas(this.canvas);
        canvas.draw();
    }

    @Override
    public void validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.LINE.getParamCount()) {
            throw new InvalidParameterException(String.format(Constant.WRONG_PARAMS, "line"));
        }
    }

    @Override
    public void validateRange(String[] parameters) throws InvalidParameterException {
        int x1 = Integer.parseInt(parameters[0]);
        int y1 = Integer.parseInt(parameters[1]);
        int x2 = Integer.parseInt(parameters[2]);
        int y2 = Integer.parseInt(parameters[3]);
        if((x1!=x2) && (y1!=y2))
            throw new InvalidParameterException(Constant.INVALID_COMMAND);
        if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
            throw new InvalidParameterException("Parameters can't be negative");
        if (x2 < x1 || y2 < y1)
            throw new InvalidParameterException("Parameters must be x2>x1 and y2>y1");
        if (x2 > this.canvas.getWidth() || y2 > this.canvas.getHeight())
            throw new InvalidParameterException("Must draw within the Canvas");
    }
}
