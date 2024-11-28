package com.OOP.CW.Backend.Model.Tickets;




public class EarlyBirdTicket {

    private int numberOfTickets;
    private float discount;


    public EarlyBirdTicket() {}


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
