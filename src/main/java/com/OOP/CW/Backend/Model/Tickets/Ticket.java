package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;

import com.OOP.CW.Backend.Model.TicketPool;
import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.Vendor;
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
    @OneToOne
    @JoinColumn(name = "vendorId", nullable = false)
    private Vendor vendor;
    @OneToOne
    @JoinColumn(name = "customerID") // set only when customer purchase the ticket
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ticketPoolId", nullable = false)
    private TicketPool ticketPool;


    public Ticket() {}

    public Ticket(Event event, TicketPool ticketPool, Vendor vendor) {
        this.event = event;
        this.ticketPool = ticketPool;
        this.vendor = vendor;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

