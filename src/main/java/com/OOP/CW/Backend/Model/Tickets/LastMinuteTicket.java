package com.OOP.CW.Backend.Model.Tickets;

public class LastMinuteTicket extends Ticket {

    private float discount;

    public LastMinuteTicket(int ticketId, double price, float discount) {
        super(ticketId, price);
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
}
