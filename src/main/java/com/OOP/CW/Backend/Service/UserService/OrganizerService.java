package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService implements UserController {

    private final OrganizerRepo organizerRepo;
    private final EventRepo eventRepo;

    @Autowired
    public OrganizerService(OrganizerRepo organizerRepo, EventRepo eventRepo) {
        this.organizerRepo = organizerRepo;
        this.eventRepo = eventRepo;
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

    @Override
    public ResponseEntity<String> deleteAccount(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(organizer.isPresent() && organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            organizerRepo.delete(organizer.get());
            return ResponseEntity.ok("Account deleted successfully.");
        } else if (organizer.isPresent() && !(organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    public ResponseEntity<List<Event>> checkEventDetails(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (organizer.isPresent()) {
            List<Event> events =eventRepo.findAllEventByOrganizer_OrganizerID(organizer.get().getOrganizerID());
            return ResponseEntity.ok(events);
        }else{
            // returns organizer not found
            return ResponseEntity.notFound().build();
        }
    }


}
