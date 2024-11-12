package com.OOP.CW.CLI.Users;

public class Customer {
    private int customerID;
    private UserCredentials userCredentials;

    public Customer() {}

    public Customer(String email, String username, String password) {
        this.userCredentials = new UserCredentials(email, username, password);
    }

    public int getCustomerID() {
        return customerID;
    }

    public UserCredentials getUsercredentials() {
        return userCredentials;
    }

}
