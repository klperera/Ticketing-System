package com.OOP.CW.CLI.Ticket;


import com.OOP.CW.CLI.Event.Event;

public class EarlyBirdTicket extends Ticket {

    private float discount;


    public EarlyBirdTicket(int ticketId, double price, float discount, Event event) {
        super(ticketId,price, event);
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String getTicketType() {
        return "EarlyBird Ticket";
    }

    @Override
    public double getTicketPrice() {
        return getPrice() * discount ;
    }
}
