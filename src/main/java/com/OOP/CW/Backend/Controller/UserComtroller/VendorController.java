package com.OOP.CW.Backend.Controller.UserComtroller;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Service.UserService.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController implements UserController {

    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<String> register(@RequestBody UserCredentials userCredentials) {
        return vendorService.register(userCredentials);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(@RequestBody String email, String password) {
        return vendorService.login(email, password);
    }

    @PostMapping("/changepassword")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody String email, String newPassword) {
        return vendorService.changePassword(email, newPassword);
    }
}
