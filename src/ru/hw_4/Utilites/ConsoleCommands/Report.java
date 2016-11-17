package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 16.11.2016.
 */
public class Report implements ConsoleExecutable {
    String args;

    public Report(String args) {
        this.args = args;
    }

    @Override
    public String execut() {
        String[] fields = args.split("\\|");
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String result = "";
        try {
            Date dateA = format.parse(fields[0]);
            Date dateB = format.parse(fields[1]);
            if (checkFieldsIsCorrect(fields)) {
                for (int i = 0; i < Main.getPurchasesArray().size(); i++) {
                    if (Main.getPurchasesArray().get(i).getDate().getTime() >= dateA.getTime() && Main.getPurchasesArray().get(i).getDate().getTime() <= dateB.getTime()){
                        result += "ID "+i+" - "+Main.getPurchasesArray().get(i).toString()+"\n";
                    }

                }

            } else {
                result = "Аргументы указанны не верно";
            }
        } catch (ParseException e) {
            result = "Аргументы указанны не верно";
        }
        if ("".equals(result))result = "Нет результатов";
        return result;
    }

    private boolean checkFieldsIsCorrect(String[] fields) {
        boolean isCorrect = true;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        if (fields.length != 2) isCorrect = false;

        try {
            Date dateA = format.parse(fields[0]);
            Date dateB = format.parse(fields[1]);
            if (dateA.getTime() > dateB.getTime()) isCorrect = false;
        }catch (ParseException e) {
            isCorrect = false;
        }
        return isCorrect;
    }
}
