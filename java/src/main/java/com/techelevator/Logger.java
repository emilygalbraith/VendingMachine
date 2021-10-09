package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Logger {
    private final String DEST_FILE_PATH = "src/test/resources/Log.txt";
    private File destFile = new File(DEST_FILE_PATH);


    public void log(String textToLog ) {

        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime time = LocalDateTime.now();
        boolean append = destFile.exists() ? true : false;
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(destFile, append))) {
            writer.println(time.format(timeStamp) + " " + textToLog);
        } catch(FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    public void logFeed(double feed, double balance) {
        String logFeed = String.format("FEED MONEY: %.2f %.2f", feed, balance);
        log(logFeed);
    }

    public void logSelection(double price, double balance, VendingMachineItem item) {
        double newBalance = balance - price;
        String logSelection = String.format("%s %s %.2f %.2f", item.getName(), item.getLocation() , balance, newBalance);
        log(logSelection);
    }

    public void logFinish(double balance) {
        String logSelection = String.format("GIVE CHANGE: %.2f %.2f", balance, .0);
        log(logSelection);
    }
}
