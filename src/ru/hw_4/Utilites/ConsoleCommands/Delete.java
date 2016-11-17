package ru.hw_4.Utilites.ConsoleCommands;

import ru.hw_4.Main;
import ru.hw_4.Utilites.XMLDB;

/**
 * Created by admin on 16.11.2016.
 */
public class Delete implements ConsoleExecutable {

    String args;

    @Override
    public String execut() {
        int id;
        try {
            id = Integer.parseInt(args);
            Main.getPurchasesArray().remove(id);
            XMLDB.setPurchasesToXML(Main.getPurchasesArray());
        } catch (NumberFormatException e) {
            return "Аргументы указанны не верно";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "ID не найден";
        } catch (IndexOutOfBoundsException e) {
            return "ID не найден";
        }
        return String.format("ID %s - запись удалена",id);
    }

    public Delete(String args) {
        this.args = args;
    }
}
