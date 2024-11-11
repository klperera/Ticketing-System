package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UserComtroller.UserController;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.UserRepository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService implements UserController {

    private final VendorRepo vendorRepo;

    @Autowired
    public VendorService(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    @Override
    public ResponseEntity<String> register(UserCredentials userCredentials) {
        Optional<UserCredentials> vendor = vendorRepo.findByuserCredentials(userCredentials.getEmail());
        if (vendor.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            vendorRepo.save(new Vendor(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }
    }

    @Override
    public ResponseEntity<String> login(String email, String password) {
        Optional<UserCredentials> vendor = vendorRepo.findByuserCredentials(email);
        if(vendor.isPresent() && vendor.get().getPassword().equals(password) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (vendor.isPresent() && !(vendor.get().getPassword().equals(password))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(String email, String newPassword) {
        Optional<UserCredentials> vendor = vendorRepo.findByuserCredentials(email);
        if (vendor.isPresent()) {
            vendor.get().setPassword(newPassword);
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }

}
