package com.techelevator;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class MoneyHandler {
    private double balance = 0.0;
    private final double QUARTER=.25;
    private final double DIME=.10;
    private final double NICKEL=.05;

    public double getBalance() { return balance; }
    public void setBalance(double balance){this.balance=balance;}


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
    public String makeChange(){
        double quarterCount=0;
        double dimeCount=0;
        double nickelCount=0;
        while(balance>=0.05){
            if(balance>=QUARTER){
                quarterCount++;
                balance-=QUARTER;
            }else if(balance>=DIME){
                dimeCount++;
                balance-=DIME;
            }else if(balance>=NICKEL){
                nickelCount++;
                balance-=NICKEL;
            }



        }
        String changeAmount="Your change is : \nQuarter :"+quarterCount+"\nDime :"+ dimeCount+ "\nNickel :"+ nickelCount;
        return changeAmount;

    }







}
