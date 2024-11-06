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

    public Organizer(String email, String username, String password) {
        this.userCredentials = new UserCredentials(email, username, password);
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }


}
