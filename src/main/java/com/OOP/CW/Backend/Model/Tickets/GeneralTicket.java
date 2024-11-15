package com.OOP.CW.Backend.Model.Tickets;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("GeneralTicket")
public class GeneralTicket extends Ticket {

    private int numberOfTickets;
    private float discount;

    public GeneralTicket() {}

    public GeneralTicket(float discount) {
        this.discount = discount;
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

    @Override
    public String getTicketType() {
        return "General Ticket";
    }

    @Override
    public double getTicketPrice() {
        return super.getPrice() * discount ;
    }
}
