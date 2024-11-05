package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Tickets.TicketPool;
import com.OOP.CW.Backend.Model.Users.Organizer;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Date;


@Entity
public class Event extends Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    private String eventName;
    private Date eventDateTime;
    private String eventLocation;
    private Duration eventDuration;
    @OneToOne
    @JoinColumn(name = "organizerID", referencedColumnName = "id")
    private Organizer organizer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketPoolId", referencedColumnName = "id")
    private TicketPool ticketPool;

    public Event(){}

    public Event(int eventID, String eventName, Date eventDateTime, String eventLocation, Duration eventDuration, Organizer organizer, TicketPool ticketPool, int maxTicketCapacity) {
        super(maxTicketCapacity);
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.eventLocation = eventLocation;
        this.eventDuration = eventDuration;
        this.organizer = organizer;
        this.ticketPool = ticketPool;
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

    public Duration getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(Duration eventDuration) {
        this.eventDuration = eventDuration;
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

    @Override
    public void saveConfig() {

    }

    @Override
    public void loadConfig() {

    }
}
