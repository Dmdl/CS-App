package com.csapp.model;

import com.csapp.exception.CanvasException;
import com.csapp.paint.Canvas;
import com.csapp.util.CanvasUtility;

public final class Shape1 {
    public enum SHAPE {LINE, RECTANGLE}

    private static final char EMPTY_PIXEL = '\u0000';
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;
    private final char symbol;
    private final SHAPE typeOfShape;

    public static class Builder {
        private final int x1;
        private final int x2;
        private final int y1;
        private final int y2;
        private char symbol;
        private final SHAPE typeOfShape;

        public Builder(int x1, int y1, int x2, int y2, SHAPE typeOfShape) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.typeOfShape = typeOfShape;
        }

        public Builder symbol(char symbol) {
            this.symbol = symbol;
            return this;
        }

        public Shape1 build() {
            return new Shape1(this);
        }
    }

    private Shape1(Builder builder) {
        this.x1 = builder.x1;
        this.x2 = builder.x2;
        this.y1 = builder.y1;
        this.y2 = builder.y2;
        this.typeOfShape = builder.typeOfShape;
        this.symbol = builder.symbol;
    }

    /**
     * draw the shape based on the type
     * @param canvas to draw
     * @throws CanvasException
     */
    public void draw(Canvas canvas) throws CanvasException {
        if (this.typeOfShape == SHAPE.LINE) {
            CanvasUtility.drawLine(x1, y1, x2, y2, canvas, 'x');
        } else if (this.typeOfShape == SHAPE.RECTANGLE) {
            this.drawRectangle(this.symbol == EMPTY_PIXEL ? 'x' : this.symbol, canvas);
        }
    }

    /**
     * Draw a rectangle with given coordinates
     *
     * @param canvas canvas to draw on
     * @param symbol to draw the rectangle
     * @throws CanvasException
     */
    private void drawRectangle(char symbol, Canvas canvas) throws CanvasException {
        CanvasUtility.drawLine(x1, y1, x2, y1, canvas, symbol);
        CanvasUtility.drawLine(x1, y2, x2, y2, canvas, symbol);
        CanvasUtility.drawLine(x1, y1, x1, y2, canvas, symbol);
        CanvasUtility.drawLine(x2, y1, x2, y2, canvas, symbol);
    }
}
