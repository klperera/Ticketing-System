package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Users.Organizer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventDOT {

    private int eventID;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String eventLocation;
    private double eventPrice;
    private String organizerEmail;
    private TicketPool ticketPool;
    private Configuration configuration;


    public EventDOT(Event event) {
        this.eventID = event.getEventID();
        this.eventName = event.getEventName();
        this.eventDate = event.getEventDate();
        this.eventTime = event.getEventTime();
        this.eventLocation = event.getEventLocation();
        this.eventPrice = event.getEventPrice();
        this.organizerEmail = event.getOrganizer().getUserCredentials().getEmail();
        this.ticketPool = event.getTicketPool();
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
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

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
