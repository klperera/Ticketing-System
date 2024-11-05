package com.OOP.CW.Backend.Model;

public abstract class Configuration {

    private final int maxTicketCapacity;            //total number of tickets for an event
    private int totalNumberOfTickets = 0;          // total number of tickets available at the moment
    private double ticketReleaseRate = 0;          // tickets available in overtime
    private double customerRetrievalRate = 0;     // customer purchase tickets overtime

    public Configuration(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public void setTotalNumberOfTickets(int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    public double getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(double ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public double getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(double customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    abstract void saveConfig();

    abstract void loadConfig();

}
