package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Entity.Purchase;
import ru.hw_4.Main;

/**
 * Created by admin on 16.11.2016.
 */
public class List implements ConsoleExecutable {
    String result ="";
    @Override
    public String execut() {
        if (Main.getPurchasesArray().size() == 0) return "Записей не найдено";

        for (int i = 0; i < Main.getPurchasesArray().size(); i++)
        {
            result += "ID "+i+" - "+Main.getPurchasesArray().get(i).toString()+"\n";
        }
        return result;
    }
}
