package com.techelevator;

public class Chip extends VendingMachineItem {
    String message = "Crunch Crunch, Yum!";

    public Chip(String name, String location, double price, String category, int quantity) {
        super(name, location, price, category, quantity);
    }

    public String getMessage() {
        return message;
    }
}
