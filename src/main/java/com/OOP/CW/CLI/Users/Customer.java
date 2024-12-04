package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Event.TicketPool;
import com.OOP.CW.CLI.Ticket.Ticket;

public class Customer implements Runnable {

    private int numberOfTickets = 0;
    private int retrievalRate = 0;
    private TicketPool ticketPool;

    public Customer(int numberOfTickets, int retrievalRate, TicketPool ticketPool) {
        this.numberOfTickets = numberOfTickets;
        this.retrievalRate = retrievalRate;
        this.ticketPool = ticketPool;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 1; i <= getNumberOfTickets(); i++) {
            ticketPool.removeTicket();
            System.out.println("Ticket removed from the TicketPool.");
            try {
                Thread.sleep(getRetrievalRate());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
