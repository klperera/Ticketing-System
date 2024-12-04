package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Event.TicketPool;
import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.List;

public class Vendor implements Runnable {

    private int numberOfTickets = 0;
    private int ticketReleaseRate = 0;
    private TicketPool ticketPool;

    public Vendor(int numberOfTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.numberOfTickets = numberOfTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
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

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 0; i < getNumberOfTickets(); i++) {
            Ticket ticket = new Ticket();
            ticketPool.addTicket(ticket);
            System.out.println("Ticket Added to TicketPool");
            try {
                Thread.sleep(getTicketReleaseRate());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
