package com.OOP.CW.Backend.Model.Tickets;


public class TicketRequest {
    private int vendorID;
    private int eventID;
    private int totalTickets;
    private EarlyBirdTicket  earlyBirdTicket;
    private GeneralTicket generalTicket;
    private LastMinuteTicket lastMinuteTicket;

    public TicketRequest(int vendorID, int eventID, int totalTickets) {
        this.vendorID = vendorID;
        this.eventID = eventID;
        this.totalTickets = totalTickets;
    }

    public TicketRequest( EarlyBirdTicket earlyBirdTicket, GeneralTicket generalTicket, LastMinuteTicket lastMinuteTicket) {
        this.earlyBirdTicket = earlyBirdTicket;
        this.generalTicket = generalTicket;
        this.lastMinuteTicket = lastMinuteTicket;

    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
    public int getTotalTicketsToPurchase() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public EarlyBirdTicket getEarlyBirdTicket() {
        return earlyBirdTicket;
    }

    public void setEarlyBirdTicket(EarlyBirdTicket earlyBirdTicket) {
        this.earlyBirdTicket = earlyBirdTicket;
    }

    public GeneralTicket getGeneralTicket() {
        return generalTicket;
    }

    public void setGeneralTicket(GeneralTicket generalTicket) {
        this.generalTicket = generalTicket;
    }

    public LastMinuteTicket getLastMinuteTicket() {
        return lastMinuteTicket;
    }

    public void setLastMinuteTicket(LastMinuteTicket lastMinuteTicket) {
        this.lastMinuteTicket = lastMinuteTicket;
    }

    public int getTotalTicketsBySubTickets(){
        return getEarlyBirdTicket().getNumberOfTickets() + getGeneralTicket().getNumberOfTickets() + getLastMinuteTicket().getNumberOfTickets();
    }
}
