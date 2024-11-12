package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.*;


@Entity
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizerID;
    @Embedded
    private UserCredentials userCredentials;

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


}
