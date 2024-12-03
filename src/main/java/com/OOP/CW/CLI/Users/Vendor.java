package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Ticket.Ticket;

public class Vendor implements Runnable {

    private int numberOfTickets = 0;
    private double ticketReleaseRate = 0;

    public Vendor(int numberOfTickets, double ticketReleaseRate) {
        this.numberOfTickets = numberOfTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public double getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(double ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public void run() {
        for (int i = 0; i < getNumberOfTickets(); i++) {
            Ticket ticket = new Ticket();
            System.out.println("Ticket created");

        }
    }


}
