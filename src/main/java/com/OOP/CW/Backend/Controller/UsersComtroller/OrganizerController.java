package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import com.OOP.CW.Backend.Service.Response;
import com.OOP.CW.Backend.Service.EventService;
import com.OOP.CW.Backend.Service.UserService.OrganizerService;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticketsystem/organizer/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrganizerController implements UserController {

    private final OrganizerRepo organizerRepo;
    private final EventRepo eventRepo;
    private final TicketPoolRepo ticketPoolRepo;
    private final VendorRepo vendorRepo;

    @Autowired
    public OrganizerController(OrganizerRepo organizerRepo, EventRepo eventRepo, VendorRepo vendorRepo, TicketPoolRepo ticketPoolRepo) {
        this.organizerRepo = organizerRepo;
        this.eventRepo = eventRepo;
        this.vendorRepo = vendorRepo;
        this.ticketPoolRepo = ticketPoolRepo;

    }
    @PostMapping("/register")
    @Override
    public Response register(@RequestBody UserCredentials userCredentials) {
        //Runnable runnable = new OrganizerService(organizerRepo,eventRepo);
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("register");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return organizerService.getResponse();
        //return organizerService.register(userCredentials) ;
    }
    @PostMapping("/login")
    @Override
    public Response login(@RequestBody UserCredentials userCredentials) {
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("login");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return organizerService.getResponse();
        //return organizerService.register(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public Response changePassword(@RequestBody UserCredentials userCredentials) {
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("changePassword");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return organizerService.getResponse();
        //return organizerService.register(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public Response deleteAccount(@RequestBody UserCredentials userCredentials) {
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("deleteAccount");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return organizerService.getResponse();
        //return organizerService.register(userCredentials);
    }

    @PostMapping("/newevent")
    public Response CreateEvent(@RequestBody Event newEvent) {
        EventService eventService = new EventService(eventRepo,organizerRepo,vendorRepo,ticketPoolRepo);
        Thread thread = new Thread(eventService);
        eventService.setEvent(newEvent);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return eventService.getResponse();
    }

    // take the current login UserCredentials details from the body
    @GetMapping("/checkevents")
    public ResponseEntity<Response> checkEventDetails(@RequestBody UserCredentials userCredentials) {
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("checkEventDetails");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return organizerService.getResponseEntity();
        //return organizerService.register(userCredentials);
    }

    public void checkEventSales(@RequestBody UserCredentials userCredentials) {
        OrganizerService organizerService = new OrganizerService(organizerRepo, eventRepo);
        Thread thread = new Thread(organizerService);
        organizerService.setMethod("");
        organizerService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        organizerService.getResponse();
        //return organizerService.register(userCredentials);
    }
}
