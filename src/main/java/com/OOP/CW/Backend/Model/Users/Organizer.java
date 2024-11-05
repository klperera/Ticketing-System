package com.OOP.CW.Backend.Model.Users;

public class Organizer {

    private int organizerID;
    private String organizerName;
    private String organizerEmail;
    private String organizerPhone;

    public Organizer(int organizerID, String organizerName, String organizerEmail, String organizerPhone) {
        this.organizerID = organizerID;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.organizerPhone = organizerPhone;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }
}
