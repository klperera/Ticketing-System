package com.OOP.CW.Backend.Controller.UserComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {


    ResponseEntity<String> register(UserCredentials userCredentials);

    ResponseEntity<String> login(String email, String password);

    ResponseEntity<String> changePassword(String email, String newPassword);

}
