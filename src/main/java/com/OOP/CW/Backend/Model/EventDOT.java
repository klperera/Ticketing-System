package com.OOP.CW.Backend.Model;


import java.time.LocalDate;
import java.time.LocalTime;


public class EventDOT {

    private int eventID;
    private String eventName;
    private String eventLocation;
    private double eventPrice;
    private String organizerEmail;
    private Configuration configuration;


    public EventDOT(Event event) {
        this.eventID = event.getEventID();
        this.eventName = event.getEventName();
        this.eventLocation = event.getEventLocation();
        this.eventPrice = event.getEventPrice();
        this.organizerEmail = event.getOrganizer().getUserCredentials().getEmail();
        this.configuration = event.getConfiguration();
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(double eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }


    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
