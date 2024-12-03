package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.List;

public class Vendor implements Runnable {

    private int numberOfTickets = 0;
    private int ticketReleaseRate = 0;

    public Vendor(int numberOfTickets, int ticketReleaseRate, List<Ticket> ticketPool) {
        this.numberOfTickets = numberOfTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
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

            try {
                Thread.sleep(getTicketReleaseRate());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {

            }


        }
    }


}
