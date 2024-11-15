package com.OOP.CW.Backend.Service;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Tickets.*;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;
    private final VendorRepo vendorRepo;
    private final EventRepo eventRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo , VendorRepo vendorRepo, EventRepo eventRepo) {
        this.ticketRepo = ticketRepo;
        this.vendorRepo = vendorRepo;
        this.eventRepo = eventRepo;
    }

    // take vendor logins, event details and number of tickets for each types
    public ResponseEntity<String> purchaseTickets(TicketRequest ticketsDetails) {
        //check whether the user logins are valid or not
        Optional<Vendor> vendor = vendorRepo.findById(ticketsDetails.getVendorID());
        if (vendor.isPresent()) {
            Optional<Event> event = eventRepo.findById(ticketsDetails.getEventID());
            //if valid check number of tickets as exceeds or not
            if (event.get().getConfiguration().getMaxTicketCapacity() <= event.get().getConfiguration().getTotalNumberOfTickets()) {
                // if all tickets are purchased
                //return ResponseEntity.ok(new Response(new Event(),"All Tickets are purchased by Vendors"));
                return ResponseEntity.badRequest().body("All Tickets are purchased by Vendors");
            }else if ((event.get().getConfiguration().getTotalNumberOfTickets() + ticketsDetails.getTotalTickets()) <= event.get().getConfiguration().getMaxTicketCapacity()) {
                // vendor purchase Tickets to sale (add to ticket pool) - add tickets to the ticket pool
                // redirect to chose how many tickets are need in every types
                for (int i = 1; i <= ticketsDetails.getEarlyBirdTicket().getNumberOfTickets(); i++) {
                    //create Early-bird tickets
                    Ticket earlyBirdTicket = new EarlyBirdTicket(ticketsDetails.getEarlyBirdTicket().getDiscount());
                    event.get().getTicketPool().addTicket(earlyBirdTicket);
                    ticketRepo.save(earlyBirdTicket);
                }
                for (int i = 1; i <= ticketsDetails.getGeneralTicket().getNumberOfTickets(); i++) {
                    //create general tickets
                    Ticket generalTicket = new GeneralTicket(ticketsDetails.getGeneralTicket().getDiscount());
                    event.get().getTicketPool().addTicket(generalTicket);
                    ticketRepo.save(generalTicket);
                }
                for (int i = 1; i <= ticketsDetails.getLastMinuteTicket().getNumberOfTickets(); i++) {
                    //create LastMinute tickets
                    Ticket lastMinuteTicket = new LastMinuteTicket(ticketsDetails.getLastMinuteTicket().getDiscount());
                    event.get().getTicketPool().addTicket(lastMinuteTicket);
                    ticketRepo.save(lastMinuteTicket);
                }
                //increment the event number of tickets
                event.get().getConfiguration().setTotalNumberOfTickets(event.get().getConfiguration().getTotalNumberOfTickets() + ticketsDetails.getTotalTickets());

                //return ResponseEntity.ok(new Response(new Event(), "Tickets purchase successfully"));
                return ResponseEntity.ok("Tickets purchase successfully");
            }else{
                //return ResponseEntity.ok(new Response(new Event(), "Can't purchase that number of tickets."));
                return ResponseEntity.badRequest().body("Can't purchase that number of tickets.");
            }
        }else {
            //return ResponseEntity.ok(new Response(vendor, "No vendor found"));
            return ResponseEntity.badRequest().body("No Vendor found");
        }
    }
}
