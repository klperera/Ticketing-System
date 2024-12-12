package com.OOP.CW.Backend.Service;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Tickets.*;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.TicketRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements Runnable {

    private final TicketRepo ticketRepo;
    private final VendorRepo vendorRepo;
    private final EventRepo eventRepo;
    private final TicketPoolRepo ticketPoolRepo;

    private Response response;
    private TicketRequest ticketRequest;

    @Autowired
    public TicketService(TicketRepo ticketRepo , VendorRepo vendorRepo, EventRepo eventRepo, TicketPoolRepo ticketPoolRepo) {
        this.ticketRepo = ticketRepo;
        this.vendorRepo = vendorRepo;
        this.eventRepo = eventRepo;
        this.ticketPoolRepo = ticketPoolRepo;
    }

    @Override
    public void run() {
        this.response = addToTicketPool(getTicketRequest());
    }

    public Response addToTicketPool(TicketRequest ticketsDetails) {
        // if all tickets are purchased - add to ticket pool
        Optional<Vendor> vendor = vendorRepo.findById(ticketsDetails.getVendorID());
        if (vendor.isPresent()) {
            Optional<Event> event = eventRepo.findById(ticketsDetails.getEventID());
            if (event.isPresent()) {
                // release all tickets at once
                if (ticketsDetails.getTotalTicketsBySubTickets() <= vendor.get().getPurchasedTickets()) {
                    // (add tickets to the pool)
                    for (int i = 1; i <= ticketsDetails.getEarlyBirdTicket().getNumberOfTickets(); i++) {
                        //Set a ticket as Early-bird ticket
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketType(ticketsDetails.getVendorID(), ticketsDetails.getEventID(),"Ticket");
                        if (ticket != null) {
                            ticket.setTicketType("EarlyBirdTicket");
                            ticket.setTicketDiscount(ticketsDetails.getEarlyBirdTicket().getDiscount());
                            ticket.setTicketPool(event.get().getTicketPool());
                            ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().addTicket(ticket);
                            vendor.get().setPurchasedTickets(vendor.get().getPurchasedTickets() - 1);
                            vendorRepo.save(vendor.get());
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticketRepo.save(ticket);
                        }


                    }
                    for (int i = 1; i <= ticketsDetails.getGeneralTicket().getNumberOfTickets(); i++) {
                        //Set a ticket as  general tickets
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketType(ticketsDetails.getVendorID(), ticketsDetails.getEventID(),"Ticket");
                        if (ticket != null) {
                            ticket.setTicketType("GeneralTicket");
                            ticket.setTicketDiscount(ticketsDetails.getGeneralTicket().getDiscount());
                            ticket.setTicketPool(event.get().getTicketPool());
                            ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().addTicket(ticket);
                            vendor.get().setPurchasedTickets(vendor.get().getPurchasedTickets() - 1);
                            vendorRepo.save(vendor.get());
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticketRepo.save(ticket);
                        }

                    }
                    for (int i = 1; i <= ticketsDetails.getLastMinuteTicket().getNumberOfTickets(); i++) {
                        //Set a ticket as  LastMinute tickets
                        Ticket ticket = ticketRepo.findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketType(ticketsDetails.getVendorID(), ticketsDetails.getEventID(),"Ticket");
                        if (ticket != null) {
                            ticket.setTicketType("LastMinuteTicket");
                            ticket.setTicketDiscount(ticketsDetails.getLastMinuteTicket().getDiscount());
                            ticket.setTicketPool(event.get().getTicketPool());
                            ticket.getTicketPool().setTickets(ticketRepo.findAllByTicketPool_ticketPoolId(event.get().getTicketPool().getTicketPoolId()));
                            ticket.getTicketPool().addTicket(ticket);
                            vendor.get().setPurchasedTickets(vendor.get().getPurchasedTickets() - 1);
                            vendorRepo.save(vendor.get());
                            ticketPoolRepo.save(ticket.getTicketPool());
                            ticketRepo.save(ticket);
                        }

                    }
                    //return ResponseEntity.ok("All tickets have been added to the pool");
                    return new Response(vendor.get(),"All tickets have been added to the pool" );
                }
                else {
                    //return ResponseEntity.ok("You dont have that amount of tickets");
                    return new Response(vendor.get(),"You dont have that amount of tickets" );

                }
            }
            else {
                //return ResponseEntity.ok("Event not found");
                return new Response(new Event(),"Event not found" );

            }
        } else {
            //return ResponseEntity.ok("vendor not found");
            return new Response(new Vendor(),"Vendor not found" );
        }
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
