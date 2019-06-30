package com.csapp.commands;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.shapes.Line;
import com.csapp.exceptions.CanvasException;

public class DrawLineCommand extends Command {
    @Override
    public String getName() {
        return "l";
    }

    @Override
    public int execute(String[] parameters) throws CanvasException {
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
    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.LINE) {
            System.out.println("Wrong parameters to addToCanvas line, please check your command");
            return false;
        }
        return true;
    }
}
