package com.OOP.CW.Backend.Model.Users;

public class Customer {

    //auto generate primary key
    private int customerID;
    private final UserCredentials usercredentials;

    public Customer(String email, String username, String password){
        this.usercredentials = new UserCredentials(email, username, password);
    }

    public int getCustomerID() {
        return customerID;
    }

    public UserCredentials getUsercredentials() {
        return usercredentials;
    }

}
