package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.UsersRepository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements UserController {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public ResponseEntity<String> register(UserCredentials userCredentials) {
        Optional<UserCredentials> customer = customerRepo.findByUserCredentials(userCredentials.getEmail());
        if (customer.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            customerRepo.save(new Customer(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }

    }

    @Override
    public ResponseEntity<String> login(String email, String password) {
        Optional<UserCredentials> customer = customerRepo.findByUserCredentials(email);
        if(customer.isPresent() && customer.get().getPassword().equals(password) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (customer.isPresent() && !(customer.get().getPassword().equals(password))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(String email, String newPassword) {
        Optional<UserCredentials> customer = customerRepo.findByUserCredentials(email);
        if (customer.isPresent()) {
            customer.get().setPassword(newPassword);
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }
}
