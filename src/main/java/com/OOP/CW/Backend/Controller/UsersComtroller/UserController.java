package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.http.ResponseEntity;

public interface UserController {


    ResponseEntity<String> register(UserCredentials userCredentials);

    ResponseEntity<String> login(String email, String password);

    ResponseEntity<String> changePassword(String email, String newPassword);

}
