package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Users.Organizer;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    private String eventName;
    private Date eventDateTime;
    private String eventLocation;
    @OneToOne
    @JoinColumn(name = "organizerID", referencedColumnName = "id")
    private Organizer organizer;
    @Embedded
    private TicketPool ticketPool;
    @Embedded
    private Configuration configuration;

    public Event(){}

    public Event(String eventName, Date eventDateTime, String eventLocation, Organizer organizer, TicketPool ticketPool, int maxTicketCapacity ) {
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.eventLocation = eventLocation;
        this.organizer = organizer;
        this.ticketPool = ticketPool;
        this.configuration = new Configuration(maxTicketCapacity);
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

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
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
