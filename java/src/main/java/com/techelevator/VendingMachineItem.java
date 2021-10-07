package com.techelevator;

public class VendingMachineItem {
    private String name;
    private String location;
    private double price;
    private String category;
    private int quantity;

    public VendingMachineItem(String name, String location, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price;}

}