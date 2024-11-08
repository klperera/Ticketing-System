package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;



public class LastMinuteTicket extends Ticket {

    private float discount;

    public LastMinuteTicket() {}

    public LastMinuteTicket(double price, float discount, Event event) {
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
        return "Last Minute Ticket";
    }

    @Override
    public double getTicketPrice() {
        return getPrice() * discount ;
    }
}
