package com.csapp.core.shapes;

import com.csapp.core.Canvas;
import com.csapp.core.Point;
import com.csapp.core.Shape;

public class Rectangle implements Shape {

    private Point topLeft;
    private Point bottomRight;
    private char symbol;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(Point topLeft, Point bottomRight, char symbol) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.symbol = symbol;
    }

    @Override
    public void addToCanvas(Canvas canvas) {
        Shape line1 = new Line(new Point(this.topLeft.getX(), this.topLeft.getY()),
                new Point(this.bottomRight.getX(), this.topLeft.getY()));
        line1.addToCanvas(canvas);
        Shape line2 = new Line(new Point(this.topLeft.getX(), this.bottomRight.getY()),
                new Point(this.bottomRight.getX(), this.bottomRight.getY()));
        line2.addToCanvas(canvas);
        Shape line3 = new Line(new Point(this.topLeft.getX(), this.topLeft.getY()),
                new Point(this.topLeft.getX(), this.bottomRight.getY()));
        line3.addToCanvas(canvas);
        Shape line4 = new Line(new Point(this.bottomRight.getX(), this.topLeft.getY()),
                new Point(this.bottomRight.getX(), this.bottomRight.getY()));
        line4.addToCanvas(canvas);
    }
}
