package com.OOP.CW.Backend.Service.UserService;

import com.OOP.CW.Backend.Controller.UsersComtroller.UserController;
import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.EventDOT;
import com.OOP.CW.Backend.Model.Tickets.Ticket;
import com.OOP.CW.Backend.Model.Tickets.TicketRequest;
import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.CustomerRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import com.OOP.CW.Backend.Service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements UserController, Runnable {

    private final CustomerRepo customerRepo;
    private final EventRepo eventRepo;
    private final VendorRepo vendorRepo;
    private final TicketRepo ticketRepo;
    private final TicketPoolRepo ticketPoolRepo;

    private String method;
    private UserCredentials userCredentials;
    private Response response;
    private TicketRequest ticketRequest;



    @Autowired
    public CustomerService(CustomerRepo customerRepo, EventRepo eventRepo, VendorRepo vendorRepo, TicketRepo ticketRepo, TicketPoolRepo ticketPoolRepo) {
        this.customerRepo = customerRepo;
        this.eventRepo = eventRepo;
        this.vendorRepo = vendorRepo;
        this.ticketRepo = ticketRepo;
        this.ticketPoolRepo = ticketPoolRepo;
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
            case "buyTickets" -> {
                this.response = buyTickets(getTicketRequest());
            }
            default -> {}
        }
    }

    @Override
    public Response register(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (customer.isPresent()) {
            return new Response(new Customer(),"User already exists, please login.");
        }
        else{
            Customer newCustomer = new Customer(userCredentials);
            customerRepo.save(newCustomer);
            return new Response(newCustomer,"User registered successfully.");
        }

    }

    @Override
    public Response login(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(customer.isPresent() && customer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            return new Response(customer,"Login successful.");
            //redirect to home page
        } else if (customer.isPresent() && !(customer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(customer.get().getUserCredentials().getEmail(),"Incorrect password. Try again.");
        } else {
            return new Response(new Customer(),"User not exists, please register first.");
        }
    }

    @Override
    public Response changePassword(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if (customer.isPresent()) {
            customer.get().getUserCredentials().setPassword(userCredentials.getPassword());
            customerRepo.save(customer.get());
            return new Response(customer.get(),"Password changed successfully.");
        }else{
            return new Response(new Customer(),"User not exists, please register first.");
        }
    }

    @Override
    public Response deleteAccount(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_Email(userCredentials.getEmail());
        if(customer.isPresent() && customer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()) ) {
            customerRepo.delete(customer.get());
            return new Response(new Customer(),"Account deleted successfully.");
        } else if (customer.isPresent() && !(customer.get().getUserCredentials().getPassword().equals(userCredentials.getPassword()))) {
            return new Response(new Customer(),"Incorrect password. Try again.");
        } else {
             return new Response(new Customer(),"User not exists, please register first.");
        }
    }

    public Response allEvents(UserCredentials userCredentials) {
        Optional<Customer> customer = customerRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (customer.isPresent()) {
            List<Event> events = eventRepo.findAll();
            List<EventDOT> eventDOTS = new ArrayList<>();
            for (Event event : events) {
                eventDOTS.add(new EventDOT(event));
            }
            return new Response(eventDOTS,"All events have been found.");
        }else{
            return new Response(new Customer(), "User not exists, please try again");
        }
    }

    public Response buyTickets(TicketRequest ticketRequest) {
        Optional<Customer> customer = customerRepo.findById(ticketRequest.getCustomerId());
        if (customer.isPresent()) {
                Optional<Event> event = eventRepo.findById(ticketRequest.getEventID());
                if (event.isPresent()) {
                    List<Ticket> ticketList = new ArrayList<>();
                    for (int i = 1; i <= ticketRequest.getEarlyBirdTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByEvent_eventIDAndTicketTypeAndCustomerIsNull(event.get().getEventID(),"EarlyBirdTicket");
                        if (ticket != null) {
                            ticket.setCustomer(customer.get());
                            ticketList.add(ticket);
                            //ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().removeTicket(ticket);
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticket.setTicketPool(null);
                            ticketRepo.save(ticket);
                            //new Response(ticket, "Ticket purchased successfully");
                        }
                    }
                    for (int i = 1; i <= ticketRequest.getGeneralTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByEvent_eventIDAndTicketTypeAndCustomerIsNull(event.get().getEventID(),"GeneralTicket");
                        if (ticket != null) {
                            ticket.setCustomer(customer.get());
                            ticketList.add(ticket);
                            //ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().removeTicket(ticket);
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticket.setTicketPool(null);
                            ticketRepo.save(ticket);
                            //new Response(ticket, "Ticket purchased successfully");
                        }

                    }
                    for (int i = 1; i <= ticketRequest.getLastMinuteTicket().getNumberOfTickets(); i++) {
                        // check request number of tickets are in the ticket pool
                        Ticket ticket = ticketRepo.findFirstTicketByEvent_eventIDAndTicketTypeAndCustomerIsNull(event.get().getEventID(),"LastMinuteTicket");
                        if (ticket != null) {
                            ticket.setCustomer(customer.get());
                            ticketList.add(ticket);
                            // ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().removeTicket(ticket);
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticket.setTicketPool(null);
                            ticketRepo.save(ticket);
                            //new Response(ticket, "Ticket purchased successfully");
                        }
                    }
                    return new Response(ticketList, "Tickets are purchased successfully");
                }
                else{
                    return new Response(new Event(), "Event not found");
                }
            }
            else{
                return new Response(new Customer(),"Customer not found");
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
}
