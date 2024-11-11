package com.OOP.CW.Backend.Controller.UserComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Service.UserService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController implements UserController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<String> register(@RequestBody UserCredentials userCredentials) {
        return customerService.register(userCredentials);
    }
    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(@RequestBody String email, String password) {
         return customerService.login(email, password);
    }

    @PostMapping("/changepassword")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody String email, String newPassword) {
        return customerService.changePassword(email, newPassword);
    }
}
