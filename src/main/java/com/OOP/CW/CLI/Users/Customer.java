package com.OOP.CW.CLI.Users;

public class Customer implements Runnable {

    private int numberOfTickets = 0;
    private double ticketReleaseRate = 0;

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(double ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {

    }
}
