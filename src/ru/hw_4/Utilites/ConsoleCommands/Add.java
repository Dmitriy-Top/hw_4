package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Entity.Purchase;
import ru.hw_4.Main;
import ru.hw_4.Utilites.XMLDB;
import ru.hw_4.assets.PurchaseType;

import java.util.Date;

/**
 * Created by admin on 16.11.2016.
 */
public class Add implements ConsoleExecutable{
    private String args;

    @Override
    public String execut() {
        String[] args = this.args.split("\\|");
        if (checkFieldsIsCorrect(args)){
            int d = Integer.parseInt(args[2]);
            Purchase purchase = new Purchase(new Date(),args[0],PurchaseType.valueOf(args[1]),Integer.parseInt(args[2]));
            Main.getPurchasesArray().add(purchase);
            XMLDB.setPurchasesToXML(Main.getPurchasesArray());
            return "Запись добавленна";
        }

        return "Аргументы указанны не верно";
    }

    public Add(String args) {
        this.args = args;
    }

    private boolean checkFieldsIsCorrect(String[] fields) {
        boolean isCorrect = true;
        if (fields.length != 3) isCorrect = false;
        try {
            if (fields[0].length() == 0) isCorrect = false;
            if (!enumContains(fields[1])) isCorrect = false;
            if (!(Integer.parseInt(fields[2]) > 0))isCorrect = false;
        } catch (NumberFormatException e) {
            isCorrect = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    private static boolean enumContains(String test) {

        for (PurchaseType c : PurchaseType.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
