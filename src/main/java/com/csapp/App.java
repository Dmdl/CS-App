package com.csapp;

import com.csapp.exception.CanvasException;
import com.csapp.model.Shape1;
import com.csapp.paint.Canvas;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static Canvas canvas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        displayHelp();
        while (!command.equals("Q")) {
            System.out.println("Command :");
            command = scanner.nextLine();
            String[] commands = command.split(" ");
            try {
                if (command.charAt(0) == 'C') {
                    canvas = new Canvas(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                }
                if (null == canvas) {
                    System.out.println("Create the canvas first");
                    continue;
                }
                if (command.charAt(0) == 'L') {
                    Shape1 line = new Shape1.Builder(Integer.parseInt(commands[1]), Integer.parseInt(commands[2])
                            , Integer.parseInt(commands[3]), Integer.parseInt(commands[4]), Shape1.SHAPE.LINE).symbol('k').build();
                    line.draw(canvas);
                    System.out.println(canvas.draw());
                } else if (command.charAt(0) == 'R') {
                    Shape1 rectangle = new Shape1.Builder(Integer.parseInt(commands[1]), Integer.parseInt(commands[2])
                            , Integer.parseInt(commands[3]), Integer.parseInt(commands[4]), Shape1.SHAPE.RECTANGLE).symbol('x').build();
                    rectangle.draw(canvas);
                    System.out.println(canvas.draw());
                } else if (command.charAt(0) == 'B') {
                    canvas.fillBucket(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), commands[3].charAt(0));
                    System.out.println(canvas.draw());
                }
            } catch (CanvasException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void displayHelp() {
        System.out.println("---------------------drawing program--------------------------------------------------");
        System.out.println("Command \t\tDescription");
        System.out.println();
        System.out.println("C w h    \t\tShould create a new canvas of width w and height h.");
        System.out.println("L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2).");
        System.out.println("R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
                "                lower right corner is (x2,y2).");
        System.out.println("B x y c         Should fill the entire area connected to (x,y) with \"colour\" c");
        System.out.println("Q               Should quit the program");
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
