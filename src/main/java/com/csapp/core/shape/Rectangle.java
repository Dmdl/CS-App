package com.csapp.core.shape;

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
    public void draw(Canvas canvas) {
        Shape line1 = new Line(new Point(this.topLeft.getX(), this.topLeft.getY()),
                new Point(this.bottomRight.getX(), this.topLeft.getY()));
        line1.draw(canvas);
        Shape line2 = new Line(new Point(this.topLeft.getX(), this.bottomRight.getY()),
                new Point(this.bottomRight.getX(), this.bottomRight.getY()));
        line2.draw(canvas);
        Shape line3 = new Line(new Point(this.topLeft.getX(), this.topLeft.getY()),
                new Point(this.topLeft.getX(), this.bottomRight.getY()));
        line3.draw(canvas);
        Shape line4 = new Line(new Point(this.bottomRight.getX(), this.topLeft.getY()),
                new Point(this.bottomRight.getX(), this.bottomRight.getY()));
        line4.draw(canvas);
    }
}
