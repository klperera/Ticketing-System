package com.OOP.CW.CLI.Users;

public class Customer implements Runnable {

    private int numberOfTickets = 0;
    private double retrievalRate = 0;

    public Customer(int numberOfTickets, double retrievalRate) {
        this.numberOfTickets = numberOfTickets;
        this.retrievalRate = retrievalRate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(double retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {

    }
}
