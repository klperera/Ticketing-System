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

    public ResponseEntity<String> addToTicketPool(TicketRequest ticketsDetails) {
        // if all tickets are purchased - add to ticket pool
        Optional<Vendor> vendor = vendorRepo.findById(ticketsDetails.getVendorID());
        if (vendor.isPresent()) {
            Optional<Event> event = eventRepo.findById(ticketsDetails.getEventID());
            if (event.isPresent()) {
                // release all tickets at once
                if (ticketsDetails.getTotalTicketsBySubTickets() <= vendor.get().getPurchasedTickets()) {
                    // vendor purchase Tickets to sale (add to tickets to the pool)
                    for (int i = 1; i <= ticketsDetails.getEarlyBirdTicket().getNumberOfTickets(); i++) {
                        //create Early-bird tickets
                        Ticket earlyBirdTicket = new EarlyBirdTicket(event.get(), ticketsDetails.getEarlyBirdTicket().getDiscount());
                        event.get().getTicketPool().addTicket(earlyBirdTicket.getTicketId());
                        ticketRepo.save(earlyBirdTicket);
                    }
                    for (int i = 1; i <= ticketsDetails.getGeneralTicket().getNumberOfTickets(); i++) {
                        //create general tickets
                        Ticket generalTicket = new GeneralTicket(event.get(), ticketsDetails.getGeneralTicket().getDiscount());
                        event.get().getTicketPool().addTicket(generalTicket.getTicketId());
                        ticketRepo.save(generalTicket);
                    }
                    for (int i = 1; i <= ticketsDetails.getLastMinuteTicket().getNumberOfTickets(); i++) {
                        //create LastMinute tickets
                        Ticket lastMinuteTicket = new LastMinuteTicket(event.get(), ticketsDetails.getLastMinuteTicket().getDiscount());
                        event.get().getTicketPool().addTicket(lastMinuteTicket.getTicketId());
                        ticketRepo.save(lastMinuteTicket);
                    }
                    return ResponseEntity.ok("All tickets have been added to the pool");
                }
                else {
                    return ResponseEntity.ok("You dont have that amount of tickets");
                }
            }
            else {
                return ResponseEntity.ok("Event not found");
            }
        } else {
            return ResponseEntity.ok("vendor not found");
        }
    }
}
