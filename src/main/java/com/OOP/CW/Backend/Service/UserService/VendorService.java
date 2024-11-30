package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.EventDOT;
import com.OOP.CW.Backend.Model.Tickets.*;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import com.OOP.CW.Backend.Service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService implements UserController, Runnable {

    private final VendorRepo vendorRepo;
    private final EventRepo eventRepo;
    private final TicketRepo ticketRepo;

    private String method;
    private UserCredentials userCredentials;
    private Response response;
    private ResponseEntity<String> responseEntity;
    private TicketRequest ticketRequest;

    @Autowired
    public VendorService(VendorRepo vendorRepo, EventRepo eventRepo, TicketRepo ticketRepo) {
        this.vendorRepo = vendorRepo;
        this.eventRepo = eventRepo;
        this.ticketRepo = ticketRepo;
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
            case "allEvents" -> {
                this.response = allEvents(getUserCredentials());
            }
            case "purchasetickets" -> {
                this.responseEntity = purchaseTickets(getTicketRequest());
            }
            default -> {}
        }
    }

    @Override
    public Response register(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (vendor.isPresent()) {
            return new Response(new Vendor(),"User already exists, please login.");
        }
        else{
            Vendor newVendor = new Vendor(userCredentials);
            vendorRepo.save(newVendor);
            return new Response(newVendor,"User registered successfully.");
        }
    }

    @Override
    public Response login(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(vendor.isPresent() && vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return new Response(vendor.get(),"Login successful.");
            //redirect to home page
        } else if (vendor.isPresent() && !(vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(vendor.get().getUserCredentials().getEmail(),"Incorrect password. Try again.");
        } else {
            return new Response(new Vendor(),"User not exists, please register first.");
        }
    }

    @Override
    public Response changePassword(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (vendor.isPresent()) {
            vendor.get().getUserCredentials().setPassword(userCredentials.getPassword());
            vendorRepo.save(vendor.get());
            return new Response(vendor.get(),"Password changed successfully.");
        }else{
            return new Response(new Vendor(),"User not exists, please register first.");
        }
    }

    @Override
    public Response deleteAccount(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(vendor.isPresent() && vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            vendorRepo.delete(vendor.get());
            return new Response(new Vendor(),"Account deleted successfully.");
        } else if (vendor.isPresent() && !(vendor.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(new Vendor(),"Incorrect password. Try again.");
        } else {
            return new Response(new Vendor(),"User not exists, please register first.");
        }
    }

    public Response allEvents(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (vendor.isPresent()) {
            List<Event> events = eventRepo.findAll();
            List<EventDOT> eventDOTS = new ArrayList<>();
            for (Event event : events) {
                eventDOTS.add(new EventDOT(event));
            }
            return new Response(eventDOTS,"All events have been found");
        }else{
            return new Response(new Vendor(),"incorrect vendor details");
        }
    }
    // take vendor logins, event details and number of tickets for each types
    public ResponseEntity<String> purchaseTickets(TicketRequest ticketsDetails) {
        //check whether the user logins are valid or not
        Optional<Vendor> vendor = vendorRepo.findById(ticketsDetails.getVendorID());
        if (vendor.isPresent()) {
            Optional<Event> event = eventRepo.findById(ticketsDetails.getEventID());
            if (event.isPresent()) {
                //if valid check number of tickets as exceeds or not
                if (event.get().getConfiguration().getMaxTicketCapacity() <= event.get().getConfiguration().getTotalNumberOfTickets()) {
                    //return ResponseEntity.ok(new Response(new Event(),"All Tickets are purchased by Vendors"));
                    return ResponseEntity.badRequest().body("All Tickets are purchased by Vendors");
                }
                else{
                    if ((event.get().getConfiguration().getTotalNumberOfTickets() + ticketsDetails.getTotalTicketsToPurchase()) <= event.get().getConfiguration().getMaxTicketCapacity()) {
                        for (int i = 0; i < ticketsDetails.getTotalTicketsToPurchase(); i++) {
                            Ticket ticket = new Ticket(event.get(),vendor.get(), "Ticket");
                            ticketRepo.save(ticket);
                        }
                        event.get().getConfiguration().setTotalNumberOfTickets(event.get().getConfiguration().getTotalNumberOfTickets() + ticketsDetails.getTotalTicketsToPurchase());
                        vendor.get().setPurchasedTickets(vendor.get().getPurchasedTickets() + ticketsDetails.getTotalTicketsToPurchase());
                        vendorRepo.save(vendor.get());
                        eventRepo.save(event.get());
                        //return ResponseEntity.ok(new Response(new Event(), "Tickets purchase successfully"));
                        return ResponseEntity.ok("Tickets purchase successfully");
                        //redirect to vendor - Add to ticket pool
                    }
                    else{
                        //return ResponseEntity.ok(new Response(new Event(), "Can't purchase that number of tickets."));
                        return ResponseEntity.badRequest().body("Can't purchase that amount of tickets.");
                    }
                }
            }else {
                return ResponseEntity.badRequest().body("Event not found.");
            }
        }
        else {
            //return ResponseEntity.ok(new Response(vendor, "No vendor found"));
            return ResponseEntity.badRequest().body("No Vendor found");
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public TicketRequest getTicketRequest() {
        return ticketRequest;
    }

    public void setTicketRequest(TicketRequest ticketRequest) {
        this.ticketRequest = ticketRequest;
    }

    public ResponseEntity<String> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<String> responseEntity) {
        this.responseEntity = responseEntity;
    }
}
