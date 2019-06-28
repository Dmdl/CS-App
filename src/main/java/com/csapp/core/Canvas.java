package com.csapp.core;

import com.csapp.core.shapes.Line;
import com.csapp.exceptions.CanvasException;
import com.csapp.util.Constant;

/**
 * Create the Canvas to draw shapes on
 */
public final class Canvas {
    private final char[][] pixels;
    private final int width;
    private final int height;

    public Canvas(int width, int height) throws CanvasException {
        if (width < 1 || height < 1)
            throw new CanvasException("Enter valid width and height");
        this.width = width + 2;
        this.height = height + 2;
        this.pixels = new char[this.height][this.width];

        Shape line1 = new Line(new Point(0, 0),new Point(this.width - 1, 0),'-');
        line1.draw(this);
        Shape line2 =new Line(new Point(0, this.height - 1),new Point(this.width - 1, this.height - 1),'-');
        line2.draw(this);
        Shape line3 = new Line(new Point(0, 1),new Point(0, this.height - 2),'|');
        line3.draw(this);
        Shape line4 = new Line(new Point(this.width - 1, 1),new Point(this.width - 1, this.height - 2),'|');
        line4.draw(this);
    }

    /**
     * Return the canvas as a String
     *
     * @return canvas
     */
    public String draw() {
        StringBuilder builder = new StringBuilder();
        for (char[] row : this.pixels) {
            for (char pixel : row) {
                builder.append(pixel == Constant.EMPTY_PIXEL ? ' ' : pixel);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Fill the enclosing area within x and y
     *
     * @param x      x coordinates
     * @param y      y coordinates
     * @param symbol to fill the area
     */
    public void fillBucket(int x, int y, char symbol) {
        if (this.pixels[y][x] != Constant.EMPTY_PIXEL)
            return;
        this.pixels[y][x] = symbol;
        fillBucket(x + 1, y, symbol);
        fillBucket(x - 1, y, symbol);
        fillBucket(x, y + 1, symbol);
        fillBucket(x, y - 1, symbol);
    }

    public char[][] getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
