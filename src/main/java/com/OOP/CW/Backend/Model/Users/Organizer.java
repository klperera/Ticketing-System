package com.OOP.CW.Backend.Model.Users;

import com.OOP.CW.Backend.Model.Event;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizerID;
    @Embedded
    private UserCredentials userCredentials;
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Event> events;

    public Organizer() {}

    public Organizer(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public List<Event> getEvents() {
        return events;
    }
}
