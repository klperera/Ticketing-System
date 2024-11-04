package com.OOP.CW.Backend.Model.Tickets;


public abstract class Ticket {

    private int ticketId;
    private double price;

    public Ticket() {}

    public Ticket(int ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
    }
    public int getTicketId() {
        return ticketId;
    }
    public double getPrice() {
        return price;
    }

    public abstract String getTicketType();
}

