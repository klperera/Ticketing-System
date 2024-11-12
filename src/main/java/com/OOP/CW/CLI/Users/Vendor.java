package com.OOP.CW.CLI.Users;

public class Vendor {

    private int vendorId;
    private UserCredentials userCredentials;

    public Vendor() {}

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
