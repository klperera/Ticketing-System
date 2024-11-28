package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.EventDOT;
import com.OOP.CW.Backend.Model.TicketPool;
import com.OOP.CW.Backend.Model.Tickets.Ticket;
import com.OOP.CW.Backend.Model.Tickets.TicketRequest;
import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.CustomerRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import com.OOP.CW.Backend.Service.Response;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements UserController {

    private final CustomerRepo customerRepo;
    private final EventRepo eventRepo;
    private final VendorRepo vendorRepo;
    private final TicketRepo ticketRepo;
    private final TicketPoolRepo ticketPoolRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo, EventRepo eventRepo, VendorRepo vendorRepo, TicketRepo ticketRepo, TicketPoolRepo ticketPoolRepo) {
        this.customerRepo = customerRepo;
        this.eventRepo = eventRepo;
        this.vendorRepo = vendorRepo;
        this.ticketRepo = ticketRepo;
        this.ticketPoolRepo = ticketPoolRepo;
    }


    @Override
    public ResponseEntity<String> register(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (customer.isPresent()) {
            return ResponseEntity.ok("User already exists, please login.");
        }
        else{
            customerRepo.save(new Customer(userCredentials));
            return ResponseEntity.ok("User registered successfully.");
        }

    }

    @Override
    public ResponseEntity<String> login(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(customer.isPresent() && customer.get().getUsercredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return ResponseEntity.ok("Login successful.");
            //redirect to home page
        } else if (customer.isPresent() && !(customer.get().getUsercredentials().getPassword().equals(userCredentials.getPassword()))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    @Override
    public ResponseEntity<String> changePassword(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (customer.isPresent()) {
            customer.get().getUsercredentials().setPassword(userCredentials.getPassword());
            customerRepo.save(customer.get());
            return ResponseEntity.ok("Password changed successfully.");
        }else{
            return ResponseEntity.ok("User not exists, please try again.");
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(customer.isPresent() && customer.get().getUsercredentials().getPassword().equals(userCredentials.getPassword()) ) {
            customerRepo.delete(customer.get());
            return ResponseEntity.ok("Account deleted successfully.");
        } else if (customer.isPresent() && !(customer.get().getUsercredentials().getPassword().equals(userCredentials.getPassword()))) {
            return ResponseEntity.ok("Incorrect password. Try again.");
        } else {
            return ResponseEntity.ok("User not exists, please register first.");
        }
    }

    public ResponseEntity<Response> allEvents(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (customer.isPresent()) {
            List<Event> events = eventRepo.findAll();
            List<EventDOT> eventDOTS = new ArrayList<>();
            for (Event event : events) {
                eventDOTS.add(new EventDOT(event));
            }
            return ResponseEntity.ok(new Response(eventDOTS,"All events have been found"));
        }else{
            return ResponseEntity.ok(new Response(new Vendor(),"incorrect Customer details"));
        }
    }

    public Response buyTickets(TicketRequest ticketRequest) {
        Optional<Customer> customer = customerRepo.findById(ticketRequest.getCustomerId());
        if (customer.isPresent()) {
            Optional<Vendor> vendor = vendorRepo.findById(ticketRequest.getVendorID());
            if (vendor.isPresent()) {
                Optional<Event> event = eventRepo.findById(ticketRequest.getEventID());
                if (event.isPresent()) {
                    for (int i = 1; i <= ticketRequest.getEarlyBirdTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketTypeAndCustomerIsNull(vendor.get().getVendorId(), event.get().getEventID(),"EarlyBirdTicket");
                        ticket.setCustomer(customer.get());
                        ticket.getTicketPool().removeTicket(ticket);
                        ticketPoolRepo.save(ticket.getTicketPool());
                        ticket.setTicketPool(null);
                        ticketRepo.save(ticket);
                        //new Response(ticket, "Ticket purchased successfully");
                    }
                    for (int i = 1; i <= ticketRequest.getGeneralTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketTypeAndCustomerIsNull(vendor.get().getVendorId(), event.get().getEventID(),"GeneralTicket");
                        ticket.setCustomer(customer.get());
                        ticket.getTicketPool().removeTicket(ticket);
                        ticketPoolRepo.save(ticket.getTicketPool());
                        ticket.setTicketPool(null);
                        ticketRepo.save(ticket);
                        //new Response(ticket, "Ticket purchased successfully");
                    }
                    for (int i = 1; i <= ticketRequest.getLastMinuteTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketTypeAndCustomerIsNull(vendor.get().getVendorId(), event.get().getEventID(),"LastMinuteTicket");
                        ticket.setCustomer(customer.get());
                        ticket.getTicketPool().removeTicket(ticket);
                        ticketPoolRepo.save(ticket.getTicketPool());
                        ticket.setTicketPool(null);
                        ticketRepo.save(ticket);
                        //new Response(ticket, "Ticket purchased successfully");
                    }
                    return new Response(new Ticket(), "Tickets are purchased successfully");
                }
                else{
                    return new Response(new Event(), "Event not found");
                }
            }
            else{
                return new Response(new Vendor(),"Vendor not found");
            }
        }
        else{
            return new Response(new Customer(),"Customer not found");
        }
    }
}
