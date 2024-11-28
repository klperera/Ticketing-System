package com.OOP.CW.Backend.Model.Tickets;


public class LastMinuteTicket{

    private int numberOfTickets;
    private float discount;

    public LastMinuteTicket() {}


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

}
