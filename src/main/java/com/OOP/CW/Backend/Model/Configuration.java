package com.OOP.CW.Backend.Model;

import jakarta.persistence.*;

@Embeddable
public class Configuration {

    private int maxTicketCapacity;                 //total number of tickets for an event
    private int totalNumberOfTickets = 0;          // total number of tickets available at the moment
    private double ticketReleaseRate = 0;          // tickets available in overtime
    private double customerRetrievalRate = 0;     // customer purchase tickets overtime

    public Configuration() {}

    public Configuration(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
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

    public void saveConfig(){
        // need to implement
    }

    public void loadConfig(){
        // need to implement
    }

}
