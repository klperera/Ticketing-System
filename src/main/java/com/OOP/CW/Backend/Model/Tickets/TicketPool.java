package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TicketPool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketPoolId;
    @OneToMany(mappedBy = "TicketPool", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    public TicketPool() {}

    public TicketPool(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getTicketPoolId() {
        return ticketPoolId;
    }

    public void setTicketPoolId(int ticketPoolId) {
        this.ticketPoolId = ticketPoolId;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
