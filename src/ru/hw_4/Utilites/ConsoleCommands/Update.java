package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Main;
import ru.hw_4.Utilites.XMLDB;

/**
 * Created by admin on 16.11.2016.
 */
public class Update implements ConsoleExecutable {
    private String args;

    public Update(String args) {
        this.args = args;
    }

    @Override
    public String execut() {
        String[] fields = args.split("\\|");
        try {
            if (checkFieldsIsCorrect(fields)) {
                int i = Integer.parseInt(fields[0]);
                Main.getPurchasesArray().get(i).setName(fields[1]);
                XMLDB.setPurchasesToXML(Main.getPurchasesArray());
            }
        } catch (NumberFormatException e) {
            return "Аргументы указанны не верно";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "ID не найден";
        } catch (IndexOutOfBoundsException e) {
            return "ID не найден";
        }
        return String.format("ID %s - запись обнавленна",fields[0]);
    }

    private boolean checkFieldsIsCorrect(String[] fields) {
        boolean isCorrect = true;
        if (fields.length != 2) isCorrect = false;
        try {
            if (!(Integer.parseInt(fields[0]) >= 0)) isCorrect = false;
            if (fields[1].length() == 0) isCorrect = false;
        } catch (NumberFormatException e) {
            isCorrect = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isCorrect = false;
        }
        return isCorrect;
    }
}
