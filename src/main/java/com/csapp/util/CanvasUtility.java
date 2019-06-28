package com.csapp.util;

import com.csapp.exceptions.CanvasException;
import com.csapp.core.Canvas;

public class CanvasUtility {

    /**
     * Draw a vertical or horizontal line
     *
     * @param x1     x coordinates of starting point
     * @param y1     y coordinates of starting point
     * @param x2     x coordinates of end point
     * @param y2     y coordinates of end point
     * @param symbol symbol to draw the line
     * @throws CanvasException
     */
    public static void drawLine(int x1, int y1, int x2, int y2, Canvas canvas, char symbol) throws CanvasException {
        if (null != canvas && (x1 < 0 || y1 < 0 || x1 > canvas.getWidth() || x2 > canvas.getWidth() || y1 > canvas.getHeight() || y2 > canvas.getHeight()))
            throw new CanvasException("Invalid parameters");
        if (y1 == y2) { //horizontal
            char[] row = canvas.getPixels()[y1];
            if (x2 > x1) {
                for (int col = x1; col <= x2; col++) {
                    row[col] = symbol;
                }
            } else {
                for (int col = x1; col >= x2; col--) {
                    row[col] = symbol;
                }
            }

        } else if (x1 == x2) { //vertical
            if (y2 > y1) {
                for (int row = y1; row <= y2; row++) {
                    for (int col = x1; col <= x2; col++) {
                        if (col == x1)
                            canvas.getPixels()[row][col] = symbol;
                    }
                }
            } else {
                for (int row = y1; row >= y2; row--) {
                    for (int col = x1; col <= x2; col++) {
                        if (col == x1)
                            canvas.getPixels()[row][col] = symbol;
                    }
                }
            }

        } else {
            throw new CanvasException("Only vertical or horizontal lines are supported");
        }
    }
}
