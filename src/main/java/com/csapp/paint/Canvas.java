package com.csapp.paint;

import com.csapp.exception.CanvasException;
import com.csapp.util.CanvasUtility;

/**
 * Create the Canvas to draw shapes on
 */
public final class Canvas {
    private final char[][] pixels;
    private final int width;
    private final int height;
    private static final char EMPTY_PIXEL = '\u0000';

    public Canvas(int width, int height) throws CanvasException {
        if (width < 1 || height < 1)
            throw new CanvasException("Enter valid width and height");
        this.width = width + 2;
        this.height = height + 2;
        this.pixels = new char[this.height][this.width];
        CanvasUtility.drawLine(0, 0, this.width - 1, 0, this, '-');
        CanvasUtility.drawLine(0, this.height - 1, this.width - 1, this.height - 1, this, '-');
        CanvasUtility.drawLine(0, 1, 0, this.height - 2, this, '|');
        CanvasUtility.drawLine(this.width - 1, 1, this.width - 1, this.height - 2, this, '|');
        System.out.println(this.draw());
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
                builder.append(pixel == EMPTY_PIXEL ? ' ' : pixel);
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
        if (this.pixels[y][x] != EMPTY_PIXEL)
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
