package com.OOP.CW.Backend.Model.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

//accept credentials as object
// frontend needs to send user data(login info) using credential class

@Component
@Embeddable
public class UserCredentials {

    @Column(unique = true, nullable = false)
    private String email;
    private String username;
    private String password;

    public UserCredentials() {}

    public UserCredentials(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail(){
        return email;
    };

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
