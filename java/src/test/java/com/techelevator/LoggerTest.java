package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoggerTest {
    Logger testLog = new Logger();
    File newFile= new File("src/test/resources/Log.txt");
    DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
    LocalDateTime time = LocalDateTime.now();
    MoneyHandler moneyHandler = new MoneyHandler();

    @Test
    public void feedLog_validInformation_Return(){
        String expected = time.format(timeStamp)+" FEED MONEY: 1.00 1.00";
        String actual = "";
        testLog.logFeed(1.0, 1.0);
       try(Scanner openFile = new Scanner(newFile)) {
           while(openFile.hasNext()){
               actual = openFile.nextLine();
           }
       } catch(FileNotFoundException ex) {
           System.out.println("File not found.");
       }
        Assert.assertEquals(expected, actual);

    }
}
