package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class TicketPool {

    @OneToMany(mappedBy = "TicketPool", cascade = CascadeType.ALL)
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
    public void addTicket(Ticket ticket) {
        //vendor add tickets
        this.tickets.add(ticket);
    }
    public void removeTicket(Ticket ticket) {
        //Customer buying ticket
        this.tickets.remove(ticket);

    }
}
