package com.csapp;

import com.csapp.commands.Command;
import com.csapp.commands.CommandFactory;
import com.csapp.exceptions.CanvasException;
import com.csapp.core.Canvas;
import com.csapp.exceptions.InvalidParameterException;

import java.util.Arrays;
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
        CommandFactory commandFactory = new CommandFactory();
        while (!command.equals("Q")) {
            System.out.println("Command :");
            command = scanner.nextLine().trim();
//            String[] commands = command.split(" ");
            String[] commands = command.trim().split("\\s*\\s+\\s*");
            String[] parameters = Arrays.copyOfRange(commands, 1, commands.length);
            char comChar = command.charAt(0);
            try {
                Command toExecute = commandFactory.getCommand(comChar);
                if (Character.toLowerCase(comChar) == 'c') {
                    toExecute.execute(parameters);
                    canvas = toExecute.getCanvas();
                } else if (toExecute != null) {
                    toExecute.setCanvas(canvas);
                    toExecute.execute(parameters);
                } else {
                    System.out.println("Invalid Command");
                }
            } catch (CanvasException | InvalidParameterException ex) {
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
