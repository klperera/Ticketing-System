package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TicketPool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketPoolId;
    private int totalTickets;
    @OneToOne(mappedBy = "ticketPool", cascade = CascadeType.ALL)
    private Event event;
    @OneToMany(mappedBy = "ticketPool", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();


    public TicketPool() {}

    public TicketPool(Event event) {
        this.event = event;
    }


    public int getTicketPoolId() {
        return ticketPoolId;
    }

    public void setTicketPoolId(int ticketPoolId) {
        this.ticketPoolId = ticketPoolId;
    }

    public void addTicket(Ticket ticket) {
        //vendor add tickets
        this.tickets.add(ticket);
        this.totalTickets++;
    }
    public Boolean removeTicket(Ticket ticket) {
        //Customer buying ticket
        this.totalTickets--;
        return this.tickets.remove(ticket);

    }
}
