package com.OOP.CW.Backend.Model;

import com.OOP.CW.Backend.Model.Users.Organizer;
import jakarta.persistence.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    private String eventName;
    private String eventLocation;
    private double eventPrice;
    @ManyToOne
    @JoinColumn(name = "organizerID", nullable = false)
    private Organizer organizer;
    @OneToOne
    @JoinColumn(name = "ticketPoolId", nullable = false)
    private TicketPool ticketPool;
    @Embedded
    private Configuration configuration;


    public Event(){}

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String eventLocation, double eventPrice, Organizer organizer, int maxTicketCapacity ) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventPrice = eventPrice;
        this.organizer = organizer;
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
