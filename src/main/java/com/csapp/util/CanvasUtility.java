package com.csapp.util;

import com.csapp.core.Point;

public class CanvasUtility {

    private CanvasUtility() {
    }

    public static String displayHelp() {
        StringBuilder builder = new StringBuilder();
        builder.append("---------------------drawing program--------------------------------------------------\n");
        builder.append("Command \t\tDescription\n");
        builder.append("\n");
        builder.append("C w h    \t\tShould create a new canvas of width w and height h.\n");
        builder.append("L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2).\n");
        builder.append("R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
                "                lower right corner is (x2,y2).\n");
        builder.append("B x y c         Should fill the entire area connected to (x,y) with \"colour\" c\n");
        builder.append("Q               Should quit the program\n");
        builder.append("--------------------------------------------------------------------------------------\n");
        builder.append("Command :\n");
        return builder.toString();
    }

    public static Point createPoint(String x, String y) {
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }
}
