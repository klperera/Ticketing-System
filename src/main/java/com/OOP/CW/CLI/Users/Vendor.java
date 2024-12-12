package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Event.TicketPool;
import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.List;

public class Vendor implements Runnable {

    private int numberOfTickets;
    private int ticketReleaseRate;
    private TicketPool ticketPool;
    private int maxCapacity;

    public Vendor(int numberOfTickets, int ticketReleaseRate, TicketPool ticketPool, int maxCapacity) {
        this.numberOfTickets = numberOfTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
        this.maxCapacity = maxCapacity;
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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void run() {
        for (int i = 0; i < getNumberOfTickets(); i++) {
            Ticket ticket = new Ticket();
            ticketPool.addTicket(ticket);
            try {
                Thread.sleep(getTicketReleaseRate());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
