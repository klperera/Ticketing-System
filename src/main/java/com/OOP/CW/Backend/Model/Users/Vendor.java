package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.*;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    @Embedded
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
