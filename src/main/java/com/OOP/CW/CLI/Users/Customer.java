package com.OOP.CW.CLI.Users;

import com.OOP.CW.CLI.Event.TicketPool;


public class Customer implements Runnable {

    private int numberOfTickets;
    private int retrievalRate;
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
        for (int i = 1; i <= getNumberOfTickets() && TicketPool.getTotalTickets() != 0; i++) {
            ticketPool.removeTicket();
            System.out.println(Thread.currentThread().getName() + " removed a ticket from the TicketPool.");
            try {
                Thread.sleep(getRetrievalRate());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
