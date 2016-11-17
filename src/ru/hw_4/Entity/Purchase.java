package ru.hw_4.Entity;

import ru.hw_4.assets.PurchaseType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 16.11.2016.
 */
public class Purchase {
    private Date date;
    private String name;
    private PurchaseType type;
    private int price;

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public PurchaseType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PurchaseType type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Purchase(Date date, String name, PurchaseType type, int price) {
        this.date = date;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        String result;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String date = formatDate.format(this.date);
        String purchaseType = this.type.toString();
        result = String.format("Название покупки: %s, дата: %s, категория: %s, стоимость: %d р.",this.name,date,purchaseType,this.price);
        return result;
    }
}
