package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.EventDOT;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import com.OOP.CW.Backend.Service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequestScope
public class OrganizerService implements UserController, Runnable {

    private final OrganizerRepo organizerRepo;
    private final EventRepo eventRepo;

    private String method;
    private UserCredentials userCredentials;
    private Response response;
    private ResponseEntity<Response> responseEntity;

    @Autowired
    public OrganizerService(OrganizerRepo organizerRepo, EventRepo eventRepo) {
        this.organizerRepo = organizerRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public void run() {
        switch (method) {
            case "register" -> {
                this.response = register(getUserCredentials());
            }
            case "login" -> {
                this.response = login(getUserCredentials());
            }
            case "changePassword" -> {
                this.response = changePassword(getUserCredentials());
            }
            case "deleteAccount" -> {
                this.response = deleteAccount(getUserCredentials());
            }
            case "checkEventDetails" -> {
                this.responseEntity = checkEventDetails(getUserCredentials());
            }
            default -> {}
        }
    }


    @Override
    public Response register(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (organizer.isPresent()) {
            return new Response(organizer.get(),"User already exists, please login.");
        }
        else{
            Organizer newOrganizer = new Organizer(userCredentials);
            organizerRepo.save(newOrganizer);
            return new Response(newOrganizer,"User registered successfully.");
        }
    }

    @Override
    public Response login(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(organizer.isPresent() && organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return new Response(organizer.get(),"Login successful.");
            //redirect to home page
        } else if (organizer.isPresent() && !(organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(organizer.get().getUserCredentials().getEmail(),"Incorrect password. Try again.");

        } else {
            return new Response(new Organizer(),"User not exists, please register first.");
        }
    }

    @Override
    public Response changePassword(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (organizer.isPresent()) {
            organizer.get().getUserCredentials().setPassword(userCredentials.getPassword());
            organizerRepo.save(organizer.get());
            return new Response(organizer.get(),"Password changed successfully.");
        }else{
            return new Response(new Organizer(),"User not exists, please try again.");
        }
    }

    @Override
    public Response deleteAccount(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(organizer.isPresent() && organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            organizerRepo.delete(organizer.get());
            return new Response(new Organizer(),"Account deleted successfully.");
        } else if (organizer.isPresent() && !(organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(new Organizer(),"Incorrect password. Try again.");
        } else {
            return new Response(new Organizer(),"User not exists, please register first.");
        }
    }

    public ResponseEntity<Response> checkEventDetails(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (organizer.isPresent()) {
            List<Event> events =eventRepo.findAllEventByOrganizer_OrganizerID(organizer.get().getOrganizerID());
            List<EventDOT> eventDOTs = new ArrayList<>();
            for (Event event : events) {
                eventDOTs.add(new EventDOT(event));
            }
            return ResponseEntity.ok(new Response(eventDOTs,"All events have been found.")) ;
        }else{
            // returns organizer not found
            return ResponseEntity.ok(new Response(new Organizer(), "User not exists, please try again")) ;
        }
    }

    public void checkEventSales(UserCredentials userCredentials) {
        Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(organizer.isPresent() && organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {

            //return ResponseEntity.ok("Account deleted successfully.");
        } else if (organizer.isPresent() && !(organizer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            //return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            //return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public Response getResponse() {
        return response;
    }

    public ResponseEntity<Response> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<Response> responseEntity) {
        this.responseEntity = responseEntity;
    }
}
