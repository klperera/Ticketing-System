package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.Entity;


public class EarlyBirdTicket extends Ticket {

    private float discount;

    public EarlyBirdTicket() {}

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
