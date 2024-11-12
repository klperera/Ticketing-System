package com.OOP.CW.CLI.Event;



import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.List;


public class TicketPool {

    private List<Ticket> tickets;


    public TicketPool() {}

    public TicketPool(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
