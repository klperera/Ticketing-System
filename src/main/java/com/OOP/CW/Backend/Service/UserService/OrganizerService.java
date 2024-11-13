package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
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
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (organizer.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            organizerRepo.save(new Organizer(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }
    }

    @Override
    public ResponseEntity<String> login(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        System.out.println(organizer.isPresent());
        if(organizer.isPresent() && organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (organizer.isPresent() && !(organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (organizer.isPresent()) {
            organizer.get().getUserCredentials().setPassword(userCredentials.getPassword());
            organizerRepo.save(organizer.get());
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }


}
