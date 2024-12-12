package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Tickets.TicketRequest;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import com.OOP.CW.Backend.Service.Response;
import com.OOP.CW.Backend.Service.TicketService;
import com.OOP.CW.Backend.Service.UserService.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticketsystem/vendor")
@CrossOrigin(origins = "http://localhost:4200")
public class VendorController implements UserController {

    private final VendorRepo vendorRepo;
    private final EventRepo eventRepo;
    private final TicketRepo ticketRepo;
    private final TicketPoolRepo ticketPoolRepo;

    @Autowired
    public VendorController(VendorRepo vendorRepo, EventRepo eventRepo, TicketRepo ticketRepo, TicketPoolRepo ticketPoolRepo) {
        this.vendorRepo = vendorRepo;
        this.eventRepo = eventRepo;
        this.ticketRepo = ticketRepo;
        this.ticketPoolRepo = ticketPoolRepo;
    }

    @PostMapping("/register")
    @Override
    public Response register(@RequestBody UserCredentials userCredentials) {
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("register");
        vendorService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vendorService.getResponse();
        //return vendorService.register(userCredentials);
    }

    @PostMapping("/login")
    @Override
    public Response login(@RequestBody UserCredentials userCredentials) {
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("login");
        vendorService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vendorService.getResponse();
        //return vendorService.login(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public Response changePassword(@RequestBody UserCredentials userCredentials) {
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("changePassword");
        vendorService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vendorService.getResponse();
        //return vendorService.changePassword(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public Response deleteAccount(@RequestBody UserCredentials userCredentials) {
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("deleteAccount");
        vendorService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vendorService.getResponse();
        //return vendorService.deleteAccount(userCredentials);
    }

    @PostMapping("/allevents")
    public Response allevents(@RequestBody UserCredentials userCredentials) {
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("allEvents");
        vendorService.setUserCredentials(userCredentials);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  vendorService.getResponse();
        //return vendorService.allEvents(userCredentials);
    }

    @PostMapping("/purchasetickets")
    public Response purchaseTickets(@RequestBody TicketRequest ticketsDetails) {
        // Ticket request - Objects of vendor, event, total tickets
        VendorService vendorService = new VendorService(vendorRepo, eventRepo, ticketRepo);
        Thread thread = new Thread(vendorService);
        vendorService.setMethod("purchasetickets");
        vendorService.setTicketRequest(ticketsDetails);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vendorService.getResponse();
        //return vendorService.purchaseTickets(ticketsDetails);
    }

    @PostMapping("/addToTicketPool")
    public Response addToTicketPool(@RequestBody TicketRequest ticketsDetails) {
        // Ticket request - earlyBirdTicket, generalTicket, lastMinuteTicket
        TicketService ticketService = new TicketService(ticketRepo, vendorRepo, eventRepo, ticketPoolRepo);
        Thread thread = new Thread(ticketService);
        ticketService.setTicketRequest(ticketsDetails);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ticketService.getResponse();
       //return ticketService.addToTicketPool(ticketsDetails);
    }

}
