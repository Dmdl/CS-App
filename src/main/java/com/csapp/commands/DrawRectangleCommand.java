package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.shapes.Rectangle;
import com.csapp.exceptions.CanvasException;
import com.csapp.exceptions.InvalidParameterException;
import com.csapp.util.CanvasUtility;
import com.csapp.util.Constant;

public class DrawRectangleCommand extends Command {
    @Override
    public String getName() {
        return "r";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException, InvalidParameterException {
        if (!this.validate(parameters)) {
            throw new InvalidParameterException(Constant.INVALID_PARAMS);
        }
        Point p1 = CanvasUtility.createPoint(parameters[0], parameters[1]);
        Point p2 = CanvasUtility.createPoint(parameters[2], parameters[3]);
        Shape rectangle = new Rectangle(p1, p2);
        rectangle.addToCanvas(this.canvas);
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) throws InvalidParameterException {
        if (parameters.length != COMMANDS.RECTANGLE.getParamCount()) {
            throw new InvalidParameterException(String.format(Constant.WRONG_PARAMS, "rectangle"));
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
            throw new InvalidParameterException("Parameters can't be negative");
        if (x1 > x2 || y2 < y1)
            throw new InvalidParameterException("Invalid parameters to draw a rectangle");
        if (x2 > this.canvas.getWidth() || y2 > this.canvas.getHeight())
            throw new InvalidParameterException("Draw within the canvas");
        return true;
    }
}
