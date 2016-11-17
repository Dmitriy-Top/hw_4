package ru.hw_4;

import ru.hw_4.Entity.*;
import ru.hw_4.Utilites.ConsoleCommands.CommandsFactory;
import ru.hw_4.Utilites.ConsoleCommands.ConsoleExecutable;
import ru.hw_4.Utilites.*;
import ru.hw_4.Utilites.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean isStop;
    private static ArrayList<Purchase> purchasesArray;
    private static Scanner sc;

    static {
        isStop = false;
        purchasesArray = XMLDB.getPurchasesFromXML();
        sc = Reader.getInstance();
    }

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в домашнюю бухгалтерию");
        System.out.println("help - список доступных команд");

        while (!isStop) {
            String input = sc.nextLine();
            ConsoleExecutable command = CommandsFactory.getCommand(input);
            String result = command.execut();
            System.out.println(result);
        }


    }

    public static void setIsStop(boolean isStop) {
        Main.isStop = isStop;
    }

    public static ArrayList<Purchase> getPurchasesArray() {
        return purchasesArray;
    }
}
