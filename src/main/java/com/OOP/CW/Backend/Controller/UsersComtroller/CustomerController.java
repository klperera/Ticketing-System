package com.OOP.CW.Backend.Controller.UsersComtroller;

import com.OOP.CW.Backend.Model.Tickets.TicketRequest;
import com.OOP.CW.Backend.Service.Response;
import com.OOP.CW.Backend.Service.UserService.CustomerService;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketsystem/customer")
public class CustomerController implements UserController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    @Override
    public Response register(@RequestBody UserCredentials userCredentials) {
        return customerService.register(userCredentials);
    }
    @PostMapping("/login")
    @Override
    public Response login(@RequestBody UserCredentials userCredentials) {
         return customerService.login(userCredentials);
    }

    @PostMapping("/changepassword")
    @Override
    public Response changePassword(@RequestBody UserCredentials userCredentials) {
        return customerService.changePassword(userCredentials);
    }

    @PostMapping("/deleteaccount")
    @Override
    public Response deleteAccount(@RequestBody UserCredentials userCredentials) {
        return customerService.deleteAccount(userCredentials);
    }

    @PostMapping("/allevents")
    public Response allevents(@RequestBody UserCredentials userCredentials) {
        return customerService.allEvents(userCredentials);
    }

    @PostMapping("/buytickets")
    public Response buyTickets(@RequestBody TicketRequest ticketRequest) {
        return customerService.buyTickets(ticketRequest);
    }

}
