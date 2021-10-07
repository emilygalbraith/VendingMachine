package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryHandler {
    private List<VendingMachineItem> inventory = new ArrayList<>();

    public List<VendingMachineItem> getInventory() { return inventory; }

    public void stockInventory() {
        File inventoryFile = new File("vendingmachine.csv");
        try (Scanner openFile = new Scanner(inventoryFile)) {
            while (openFile.hasNext()) {
                String lineOfInput = openFile.nextLine();
                String[] itemInfo = lineOfInput.split("\\|");
                String location = itemInfo[0];
                String name = itemInfo[1];
                double price = Double.parseDouble(itemInfo[2]);
                String category = itemInfo[3];
                int quantity = 5;
                if(category.equals("Chip")) {
                    Chip newChip = new Chip(name, location, price, category, quantity);
                    inventory.add(newChip);
                } else if(category.equals("Candy")) {
                    Candy newCandy = new Candy(name, location, price, category, quantity);
                    inventory.add(newCandy);
                } else if(category.equals("Drink")) {
                    Drink newDrink = new Drink(name, location, price, category, quantity);
                    inventory.add(newDrink);
                } else if(category.equals("Gum")) {
                    Gum newGum = new Gum(name, location, price, category, quantity);
                    inventory.add(newGum);
                } else {
                    System.out.println("Invalid Category");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
