package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class TicketPool {

    @OneToMany(mappedBy = "ticketId", cascade = CascadeType.ALL)
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
