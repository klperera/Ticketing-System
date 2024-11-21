package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.TicketPool;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("GeneralTicket")
public class GeneralTicket extends Ticket {

    @Transient
    private int numberOfTickets;
    private float discount;
    private double price;

    public GeneralTicket() {}

    public GeneralTicket(Event event, TicketPool ticketPool, float discount) {
        super(event, ticketPool);
        this.discount = discount;
        this.price = getEvent().getEventPrice() * discount;
    }

    public GeneralTicket(int numberOfTickets, float discount) {
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
