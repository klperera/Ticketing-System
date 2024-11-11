package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UserComtroller.UserController;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.UserRepository.OrganizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizerService implements UserController {

    private final OrganizerRepo organizerRepo;

    @Autowired
    public OrganizerService(OrganizerRepo organizerRepo) {
        this.organizerRepo = organizerRepo;
    }


    @Override
    public ResponseEntity<String> register(UserCredentials userCredentials) {
        Optional<UserCredentials> organizer = organizerRepo.findByuserCredentials(userCredentials.getEmail());
        if (organizer.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            organizerRepo.save(new Organizer(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }
    }

    @Override
    public ResponseEntity<String> login(String email, String password) {
        Optional<UserCredentials> organizer = organizerRepo.findByuserCredentials(email);
        if(organizer.isPresent() && organizer.get().getPassword().equals(password) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (organizer.isPresent() && !(organizer.get().getPassword().equals(password))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(String email, String newPassword) {
        Optional<UserCredentials> organizer = organizerRepo.findByuserCredentials(email);
        if (organizer.isPresent()) {
            organizer.get().setPassword(newPassword);
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }


}
