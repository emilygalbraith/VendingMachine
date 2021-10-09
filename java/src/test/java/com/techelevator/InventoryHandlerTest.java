package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class InventoryHandlerTest {
    InventoryHandler inventoryHandler = new InventoryHandler();
    List<VendingMachineItem> testInventory = inventoryHandler.getInventory();

    @Before
    public void setUp() {
        inventoryHandler.stockInventory();
    }

    @Test
    public void stockInventoryMethod_StocksAsExpected() {
        int expectedQuantity = 5;
        int actualQuantity = 0;
        String message = "";
        for (VendingMachineItem item : testInventory) {
            if (item.getQuantity() < expectedQuantity){
                message = item.getName() + "was not restocked to 5.";
                break;
            } else {
                actualQuantity = item.getQuantity();
            }
        }
        Assert.assertEquals(message ,expectedQuantity, actualQuantity);

    }

    @Test
    public void selectProductMethod_ValidItem_ReturnsExpected() {
        String expected = String.format("Potato Crisps: 3.05. Crunch Crunch, Yum!");
        String actual = inventoryHandler.selectProduct("A1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectProductMethod_InvalidItem_ReturnsStringInforming() {
        String expected = String.format("Please select the valid product");
        String actual = inventoryHandler.selectProduct("Z1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectProductMethod_SoldOutItem_ReturnsSoldOut() {
        String expected = String.format("Sold Out");
        VendingMachineItem testItem = testInventory.get(0);
        testItem.setQuantity(0);
        String actual = inventoryHandler.selectProduct("A1");
        Assert.assertEquals(expected, actual);
    }
}
