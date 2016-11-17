package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Main;

/**
 * Created by admin on 16.11.2016.
 */
public class Exit implements ConsoleExecutable{
    @Override
    public String execut() {
        Main.setIsStop(true);
        return "До свидания!";
    }
}
