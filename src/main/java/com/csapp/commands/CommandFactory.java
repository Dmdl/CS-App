package com.csapp.commands;

public class CommandFactory {
    public Command getCommand(Character cmd) {
        if (cmd == null) {
            return null;
        }
        cmd = Character.toLowerCase(cmd);
        if (cmd.equals('c')) {
            return new DrawCanvasCommand();
        } else if (cmd.equals('l')) {
            return new DrawLineCommand();
        } else if (cmd.equals('r')) {
            return new DrawRectangleCommand();
        } else if (cmd.equals('b')) {
            return new FillBucketCommand();
        } else if (cmd.equals('q')) {
            return new QuiteCommand();
        }
        return null;
    }
}
