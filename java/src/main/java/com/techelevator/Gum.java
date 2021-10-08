package com.techelevator;

public class Gum extends VendingMachineItem {
    String message = "Chew Chew, Yum!";

    public Gum(String name, String location, double price, String category, int quantity) {
        super(name, location, price, category, quantity);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
