package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    @Embedded
    private UserCredentials userCredentials;

    public Customer() {}

    public Customer(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public int getCustomerID() {
        return customerID;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

}
