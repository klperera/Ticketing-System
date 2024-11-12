package com.OOP.CW.CLI.Ticket;


import com.OOP.CW.CLI.Event.Event;

public class EarlyBirdTicket extends Ticket {

    private float discount;


    public EarlyBirdTicket(Event event, double price, float discount) {
        super(price, event);
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
