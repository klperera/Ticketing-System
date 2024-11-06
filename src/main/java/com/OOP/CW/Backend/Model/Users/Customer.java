package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    @Embedded
    private UserCredentials usercredentials;

    public Customer() {}

    public Customer(String email, String username, String password) {
        this.usercredentials = new UserCredentials(email, username, password);
    }

    public int getCustomerID() {
        return customerID;
    }

    public UserCredentials getUsercredentials() {
        return usercredentials;
    }

}
