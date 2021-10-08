package com.techelevator;

public class Candy extends VendingMachineItem {
    String message = "Munch Munch, Yum!";

    public Candy(String name, String location, double price, String category, int quantity) {
        super(name, location, price, category, quantity);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
