package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ticketType", discriminatorType = DiscriminatorType.STRING)
public abstract class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private double price;
    @ManyToOne
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    private Event event;

    public Ticket() {}

    public Ticket(double price, Event event) {
        this.price = price;
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }

    public double getPrice() {
        return price;
    }

    public Event getEvent() {
        return event;
    }

    public int getEventIdInTicket(){
        return getEvent().getEventID();
    }

    abstract String getTicketType();
    abstract double getTicketPrice();
}

