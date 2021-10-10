package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyHandlerTest {
    MoneyHandler moneyHandler=new MoneyHandler();

    @Test
    public void testCustomerAmount_addToBalance_returnValue(){
        String expected="Current Money Provided: $2.00";
        String actual = moneyHandler.customerAmount(2);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCustomerAmount_SubtractToSelectionItem_returnValue(){
        moneyHandler.customerAmount(2);
        String expected="Money Remaining: 1.25" ;
        String actual =moneyHandler.deductPriceOfSelection(0.75);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testGetBalance_returnValue(){
        moneyHandler.customerAmount(2);
       double expected=2;
       double actual = moneyHandler.getBalance();
        Assert.assertEquals(expected,actual,1);
    }
    @Test
    public void testMakeChangeQuarter_ValidData_returnValue(){
        moneyHandler.setBalance(2.0);
       String expected="Your change is : \nQuarter :8.0\nDime :0.0\nNickel :0.0";
       String actual= moneyHandler.makeChange();
       Assert.assertEquals(expected,actual);

}
    @Test
    public void testMakeChangeDime_ValidData_returnValue(){
        moneyHandler.setBalance(.20);
        String expected="Your change is : \nQuarter :0.0\nDime :2.0\nNickel :0.0";
        String actual= moneyHandler.makeChange();
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testMakeChangeNickel_ValidData_returnValue(){
        moneyHandler.setBalance(.05);
        String expected="Your change is : \nQuarter :0.0\nDime :0.0\nNickel :1.0";
        String actual= moneyHandler.makeChange();
        Assert.assertEquals(expected,actual);

    }


}



