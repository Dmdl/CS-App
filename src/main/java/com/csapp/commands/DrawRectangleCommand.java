package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.shapes.Rectangle;
import com.csapp.exceptions.CanvasException;

public class DrawRectangleCommand extends Command {
    @Override
    public String getName() {
        return "r";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException {
        if (!this.validate(parameters)) {
            return -1;
        }
        Point p3 = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Point p4 = new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
        Shape rectangle = new Rectangle(p3, p4);
        rectangle.addToCanvas(this.canvas);
        canvas.draw();
        return 0;
    }

    @Override
    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.RECTANGLE) {
            System.out.println("Wrong parameters to draw rectangle, please check your command");
            return false;
        }
        return true;
    }
}
