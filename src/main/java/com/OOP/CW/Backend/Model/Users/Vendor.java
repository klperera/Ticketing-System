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

    public Vendor(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public int getVendorId() {
        return vendorId;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

}
