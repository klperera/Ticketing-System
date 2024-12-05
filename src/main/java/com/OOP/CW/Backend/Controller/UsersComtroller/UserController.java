package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Service.Response;
import org.springframework.http.ResponseEntity;

public interface UserController {

    Response register(UserCredentials userCredentials);

    Response login(UserCredentials userCredentials);

    Response changePassword(UserCredentials userCredentials);

    Response deleteAccount(UserCredentials userCredentials);

}
