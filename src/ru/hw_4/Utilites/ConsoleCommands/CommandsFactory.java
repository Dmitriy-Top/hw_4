package ru.hw_4.Utilites.ConsoleCommands;

/**
 * Created by admin on 15.11.2016.
 */
public class CommandsFactory {
    public static ConsoleExecutable getCommand(String input) {
        String[] command = input.split("\\s+");
        String args ="";
        for (int i = 1; i< command.length;i++){
            args += command[i];
            if (i!=command.length-1) args+=" ";
        }

        switch (command[0]) {
            case "add":
                return new Add(args);
            case "update":
                return new Update(args);
            case "delete":
                return new Delete(args);
            case "list":
                return new List();
            case "report":
                return new Report(args);
            case "help":
                return new Help();
            case "exit":
                return new Exit();
            default:
                return new Help();
        }
    }
}
