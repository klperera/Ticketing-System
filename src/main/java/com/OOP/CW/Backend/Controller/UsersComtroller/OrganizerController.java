package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Service.Response;
import com.OOP.CW.Backend.Service.EventService;
import com.OOP.CW.Backend.Service.UserService.OrganizerService;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketsystem/organizer")
public class OrganizerController implements UserController {

    private final OrganizerService organizerService;
    private final EventService eventService;

    @Autowired
    public OrganizerController(OrganizerService organizerService, EventService eventService) {
        this.organizerService = organizerService;
        this.eventService = eventService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<String> register(@RequestBody UserCredentials userCredentials) {
        return organizerService.register(userCredentials);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(@RequestBody UserCredentials userCredentials) {
        return organizerService.login(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody UserCredentials userCredentials) {
        return organizerService.changePassword(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public ResponseEntity<String> deleteAccount(@RequestBody UserCredentials userCredentials) {
        return organizerService.deleteAccount(userCredentials);
    }

    @PostMapping("/newevent")
    public ResponseEntity<Response> CreateEvent(@RequestBody Event newEvent) {
        return eventService.createEvent(newEvent);
    }

    // take the current login UserCredentials details from the body
    @GetMapping("/checkevents")
    public ResponseEntity<Response> checkEventDetails(@RequestBody UserCredentials userCredentials) {
        return organizerService.checkEventDetails(userCredentials);
    }

    public void checkEventSales(@RequestBody UserCredentials userCredentials) {
        organizerService.checkEventSales(userCredentials);
    }
}
