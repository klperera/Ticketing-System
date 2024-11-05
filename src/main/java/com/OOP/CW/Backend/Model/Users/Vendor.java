package com.OOP.CW.Backend.Model.Users;

public class Vendor {

    //auto generate primary key
    private int vendorId;
    private final UserCredentials userCredentials;

    public Vendor(String email, String username, String password) {
        this.userCredentials = new UserCredentials(email, username, password);
    }

    public int getVendorId() {
        return vendorId;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

}
