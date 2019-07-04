package com.csapp;

import com.csapp.commands.Command;
import com.csapp.commands.CommandFactory;
import com.csapp.exceptions.CanvasException;
import com.csapp.core.Canvas;
import com.csapp.exceptions.InvalidParameterException;
import com.csapp.exceptions.QuiteDrawingException;
import com.csapp.util.CanvasUtility;
import com.csapp.util.Constant;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static CommandFactory commandFactory;
    private static Scanner scanner;
    private static Canvas canvas;

    static {
        commandFactory = new CommandFactory();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println(CanvasUtility.displayHelp());
        while (true) {
            String userInput = scanner.nextLine().trim();
            String[] commands = userInput.split(Constant.REGEX_REMOVE_WHITE_SPACE);
            String[] parameters = Arrays.copyOfRange(commands, 1, commands.length);
            Character comChar = userInput.length() > 0 ? userInput.charAt(0) : null;
            try {
                Command toExecute = commandFactory.getCommand(comChar);
                if (null == toExecute) {
                    System.out.println(Constant.INVALID_COMMAND);
                    System.out.println(CanvasUtility.displayHelp());
                    continue;
                }
                if (Character.toLowerCase(comChar) == 'c') {
                    toExecute.execute(parameters);
                    canvas = toExecute.getCanvas();
                } else {
                    toExecute.setCanvas(canvas);
                    toExecute.execute(parameters);
                }
            } catch (CanvasException | InvalidParameterException ex) {
                System.out.println(ex.getMessage());
                System.out.println(CanvasUtility.displayHelp());
            }catch (QuiteDrawingException ex){
                System.out.println(ex.getMessage());
                break;
            }
        }
    }
}
