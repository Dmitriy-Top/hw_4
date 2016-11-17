package ru.hw_4.Utilites.ConsoleCommands;

/**
 * Created by admin on 16.11.2016.
 */
public class Help implements ConsoleExecutable{
    @Override
    public String execut() {
        String result = "add картошка|Food|15\nupdate 0|марковь \ndelete 0\nlist \nreport 19.12.2016|20.12.2016 \nhelp \nexit";
        return result;
    }
}
