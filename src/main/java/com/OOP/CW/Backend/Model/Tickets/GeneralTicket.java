package com.OOP.CW.Backend.Model.Tickets;


public class GeneralTicket {


    private int numberOfTickets;
    private float discount;

    public GeneralTicket() {}


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
