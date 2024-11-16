package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ticketType", discriminatorType = DiscriminatorType.STRING)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    private Event event;

    public Ticket() {}

    public Ticket(Event event) {
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Event getEvent() {
        return event;
    }

}

