package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<String> register(UserCredentials userCredentials);

    ResponseEntity<String> login(UserCredentials userCredentials);

    ResponseEntity<String> changePassword(UserCredentials userCredentials);

    ResponseEntity<String> deleteAccount(UserCredentials userCredentials);

}
