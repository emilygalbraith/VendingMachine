package com.techelevator;

import java.math.BigDecimal;

public class MoneyHandler {
    private double balance = .0;

    // feed money to balance
    public String customerAmount(double money) {
        balance += money;
        String currentMoney = String.format("Current Money Provided: $%.2f",balance);
        return currentMoney;
    }

    //deduct cost of item from balance
    public String deductPriceOfSelection(double price) {
        balance -= price;
        String stringBalance = String.format("Money Remaining: %.2f", balance);
        return stringBalance;
    }
}
