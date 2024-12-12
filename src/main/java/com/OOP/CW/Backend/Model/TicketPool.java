package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class TicketPool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketPoolId;
    private int totalTickets;
    @OneToOne(mappedBy = "ticketPool", cascade = CascadeType.ALL)
    private Event event;
    @OneToMany(mappedBy = "ticketPool", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets = Collections.synchronizedList(new ArrayList<>());


    public TicketPool() {}

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

    public synchronized void addTicket(Ticket ticket) {
        //vendor add tickets
        this.tickets.add(ticket);
        this.totalTickets++;
    }
    public synchronized void removeTicket(Ticket ticket) {
        //Customer buying ticket
        this.totalTickets--;
        this.tickets.remove(ticket);
    }
}
