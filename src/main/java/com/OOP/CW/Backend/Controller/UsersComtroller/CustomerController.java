package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Service.UserService.CustomerService;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketsystem/customer")
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
    public ResponseEntity<String> login(@RequestBody UserCredentials userCredentials) {
         return customerService.login(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody UserCredentials userCredentials) {
        return customerService.changePassword(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public ResponseEntity<String> deleteAccount(UserCredentials userCredentials) {
        return customerService.deleteAccount(userCredentials);
    }
}
