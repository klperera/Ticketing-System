package com.OOP.CW.Backend.Model;

import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class TicketPool {

    //@OneToMany(mappedBy = "TicketPool", cascade = CascadeType.ALL)
    @ElementCollection
    private List<Integer> tickets;


    public TicketPool() {}

    public TicketPool(List<Integer> tickets) {
        this.tickets = tickets;
    }

    public List<Integer> getTickets() {
        return tickets;
    }

    public void setTickets(List<Integer> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(int ticketID) {
        //vendor add tickets
        this.tickets.add(ticketID);
    }
    public int removeTicket(int ticketID) {
        //Customer buying ticket
        return this.tickets.remove(ticketID);

    }
}
