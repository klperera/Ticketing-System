package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;

import com.OOP.CW.Backend.Model.TicketPool;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ticketType", discriminatorType = DiscriminatorType.STRING)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;
    @ManyToOne
    @JoinColumn(name = "ticketPoolId", nullable = false)
    private TicketPool ticketPool;


    public Ticket() {}

    public Ticket(Event event, TicketPool ticketPool) {
        this.event = event;
        this.ticketPool = ticketPool;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }
}

