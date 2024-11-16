package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.*;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    private int purchasedTickets;
    @Embedded
    private UserCredentials userCredentials;

    public Vendor() {}

    public Vendor(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Vendor(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setPurchasedTickets(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

}
