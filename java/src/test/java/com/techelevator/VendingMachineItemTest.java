package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class VendingMachineItemTest {
    VendingMachineItem testItem = new VendingMachineItem();
    InventoryHandler inventoryHandler = new InventoryHandler();
    List<VendingMachineItem> testInventory = inventoryHandler.getInventory();

    @Before
    public void setUp() {
        inventoryHandler.stockInventory();
    }


    @Test
    public void isSoldOutMethod_SoldOut_ShouldReturnSoldOut(){
        testItem.setQuantity(0);
        String expected = "Sold out";
        String actual = testItem.isSoldOut();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isSoldOutMethod_NotSoldOut_ShouldReturnEmptyString(){
        testItem.setQuantity(1);
        String expected = "";
        String actual = testItem.isSoldOut();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCategory_ValidData_ShouldReturnExpected() {
        String expected = "Chip";
        testItem = testInventory.get(0);
        String actual = testItem.getCategory();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMessage_ValidData_ShouldReturnExpected() {
        String expected = "Crunch Crunch, Yum!";
        testItem = testInventory.get(0);
        String actual = testItem.getMessage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName_ValidData_ShouldReturnExpected() {
        String expected = "Chip";
        testItem = testInventory.get(0);
        testItem.setName("Chip");
        String actual = testItem.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPrice_ValidData_ShouldReturnExpected() {
        double expected = 1.0;
        testItem = testInventory.get(0);
        testItem.setPrice(1.0);
        double actual = testItem.getPrice();
        Assert.assertEquals(expected, actual, 1);
    }
}
