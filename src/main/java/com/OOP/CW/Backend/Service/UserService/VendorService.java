package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
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
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (vendor.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            vendorRepo.save(new Vendor(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }
    }

    @Override
    public ResponseEntity<String> login(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(vendor.isPresent() && vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (vendor.isPresent() && !(vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (vendor.isPresent()) {
            vendor.get().getUserCredentials().setPassword(userCredentials.getPassword());
            vendorRepo.save(vendor.get());
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }

}
