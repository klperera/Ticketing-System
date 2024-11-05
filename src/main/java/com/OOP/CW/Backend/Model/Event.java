package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Users.Organizer;

import java.time.Duration;
import java.util.Date;

public class Event extends Configuration {

    private int eventID;
    private String eventName;
    private Date eventDateTime;
    private String eventLocation;
    private Duration eventDuration;
    private Organizer organizer;

    public Event(int eventID, String eventName, Date eventDateTime, String eventLocation, Duration eventDuration, Organizer organizer, int maxTicketCapacity) {
        super(maxTicketCapacity);
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.eventLocation = eventLocation;
        this.eventDuration = eventDuration;
        this.organizer = organizer;
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

    @Override
    public void saveConfig() {

    }

    @Override
    public void loadConfig() {

    }
}
