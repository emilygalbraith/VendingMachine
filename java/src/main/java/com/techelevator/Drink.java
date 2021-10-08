package com.techelevator;

public class Drink extends VendingMachineItem {
    String message = "Glug Glug, Yum!";

    public Drink(String name, String location, double price, String category, int quantity) {
        super(name, location, price, category, quantity);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
