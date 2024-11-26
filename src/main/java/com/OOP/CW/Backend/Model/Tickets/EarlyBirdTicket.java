package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.TicketPool;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("Early-birdTicket")
public class EarlyBirdTicket extends Ticket {

    @Transient
    private int numberOfTickets;
    private float discount;
    private double price;


    public EarlyBirdTicket() {}

    public EarlyBirdTicket(Event event, float discount) {
        super(event);
        this.discount = discount;
        this.price = (super.getEvent().getEventPrice() * discount)/100;
    }

    public EarlyBirdTicket(int numberOfTickets,float discount) {
        this.numberOfTickets = numberOfTickets;
        this.discount = discount;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public double getTicketPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
