package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String DEST_FILE_PATH = "src/test/resources/Log.txt";
    private DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private File destFile = new File(DEST_FILE_PATH);

    public void log(String textToLog ) {
        try(PrintWriter writer = new PrintWriter(destFile)) {
            writer.println(textToLog);
        } catch(FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    public void logFeed(double feed, double balance) {
        String logFeed = String.format("FEED MONEY: %.2f %.2f", feed, balance);
        logFeed = timeStamp + logFeed;
        log(logFeed);
    }

    public void logSelection(double price, double balance) {
        double newBalance = balance - price;
        String logSelection = String.format("FEED MONEY: %.2f %.2f", balance, newBalance);
        logSelection = timeStamp + logSelection;
        log(logSelection);
    }

    public void logFinish(double balance) {
        String logSelection = String.format("FEED MONEY: %.2f %.2f", balance, 0);
        logSelection = timeStamp + logSelection;
        log(logSelection);
    }
}
