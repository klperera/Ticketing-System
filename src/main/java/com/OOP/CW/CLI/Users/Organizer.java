package com.OOP.CW.CLI.Users;


public class Organizer {

    private int organizerID;

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
