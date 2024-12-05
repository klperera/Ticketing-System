package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;

import com.OOP.CW.Backend.Model.TicketPool;
import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.Vendor;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;
    @OneToOne
    @JoinColumn(name = "customerID") // set only when customer purchase the ticket
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ticketPoolId")
    private TicketPool ticketPool;
    @ManyToOne
    @JoinColumn(name = "vendorId", nullable = false)
    private Vendor vendor;
    private String ticketType;
    private double ticketPrice;
    private double ticketDiscount;


    public Ticket() {}

    public Ticket(Event event, Vendor vendor, String ticketType) {
        this.event = event;
        this.vendor = vendor;
        this.ticketType = ticketType;
        this.ticketPrice = getEvent().getEventPrice();
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
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketDiscount() {
        return ticketDiscount;
    }

    public void setTicketDiscount(double ticketDiscount) {
        this.ticketDiscount = ticketDiscount;
        setTicketPrice(getEvent().getEventPrice() - ((getEvent().getEventPrice() * ticketDiscount))/100);
    }
}

