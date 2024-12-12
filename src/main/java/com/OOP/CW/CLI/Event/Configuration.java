package com.OOP.CW.CLI.Event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class Configuration {

    private int maxTicketCapacity;                 //total number of tickets for an event
    private int totalNumberOfTickets;          // total number of tickets available at the moment
    private double ticketReleaseRate;         // tickets available in overtime
    private double customerRetrievalRate;     // customer purchase tickets overtime

    public Configuration() {}

    public Configuration(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public void setTotalNumberOfTickets(int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    public double getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(double ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public double getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(double customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }
    public void saveToJson(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Configuration loadFromJson(String filePath) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e) {
            System.out.println("File not found");
            Configuration config = new Configuration();
            System.out.println("Enter System configurations...");
            System.out.print("Enter Max Capacity :");
            config.setMaxTicketCapacity(scanner.nextInt());
            return config;
        }
    }

}
