package com.OOP.CW.CLI.Ticket;

import com.OOP.CW.Backend.Model.Event;


public abstract class Ticket {

    private int ticketId;
    private double price;
    private Event event;

    public Ticket(int ticketId, double price, Event event) {
        this.ticketId = ticketId;
        this.price = price;
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
