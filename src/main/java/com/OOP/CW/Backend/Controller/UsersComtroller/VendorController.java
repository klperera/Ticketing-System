package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Tickets.TicketRequest;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Service.EventService;
import com.OOP.CW.Backend.Service.Response;
import com.OOP.CW.Backend.Service.TicketService;
import com.OOP.CW.Backend.Service.UserService.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ticketsystem/vendor")
public class VendorController implements UserController {

    private final VendorService vendorService;
    private final EventService eventService;
    private final TicketService ticketService;

    @Autowired
    public VendorController(VendorService vendorService, EventService eventService, TicketService ticketService) {
        this.vendorService = vendorService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<String> register(@RequestBody UserCredentials userCredentials) {
        return vendorService.register(userCredentials);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(@RequestBody UserCredentials userCredentials) {
        return vendorService.login(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody UserCredentials userCredentials) {
        return vendorService.changePassword(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public ResponseEntity<String> deleteAccount(@RequestBody UserCredentials userCredentials) {
        return vendorService.deleteAccount(userCredentials);
    }

    @PostMapping("/allevents")
    public ResponseEntity<Response> allevents(@RequestBody UserCredentials userCredentials) {
        return eventService.allEvents(userCredentials);
    }

    @PostMapping("/purchasetickets")
    public ResponseEntity<String> purchaseTickets(@RequestBody TicketRequest ticketsDetails) {
        // Ticket request - Objects of vendor, eventID, total tickets
        return vendorService.purchaseTickets(ticketsDetails);
    }

    @PostMapping("/addToTicketPool")
    public ResponseEntity<String> addToTicketPool(@RequestBody TicketRequest ticketsDetails) {
        System.out.println(ticketsDetails.getVendorID());
        // Ticket request - earlyBirdTicket, generalTicket, lastMinuteTicket
       return ticketService.addToTicketPool(ticketsDetails);
    }

}
