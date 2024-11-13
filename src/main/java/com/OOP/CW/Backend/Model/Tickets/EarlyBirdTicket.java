package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Early-birdTicket")
public class EarlyBirdTicket extends Ticket {

    private float discount;

    public EarlyBirdTicket() {}

    public EarlyBirdTicket(float discount) {
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
        return super.getPrice() * discount ;
    }
}
