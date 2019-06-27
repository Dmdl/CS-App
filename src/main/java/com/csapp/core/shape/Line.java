package com.csapp.core.shape;

import com.csapp.core.Point;
import com.csapp.core.Shape;
import com.csapp.core.Canvas;
import com.csapp.util.Constant;

public class Line implements Shape {
    private Point start;
    private Point end;
    private char symbol;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(Point start, Point end, char symbol) {
        this.start = start;
        this.end = end;
        this.symbol = symbol;
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.start.getY() == this.end.getY()) {
            char[] row = canvas.getPixels()[start.getY()];
            for (int col = this.start.getX(); col <= this.end.getX(); col++) {
                row[col] = symbol == Constant.EMPTY_PIXEL ? 'x' : symbol;
            }
        } else if (this.start.getX() == this.end.getX()) {
            for (int row = this.start.getY(); row <= this.end.getY(); row++) {
                canvas.getPixels()[row][this.start.getX()] = symbol == Constant.EMPTY_PIXEL ? 'x' : symbol;
            }
        }
    }
}
