package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import com.OOP.CW.Backend.Model.Users.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    Ticket findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketType(int vendorId, int eventID, String ticketType);

    Ticket findFirstTicketByVendor_VendorIdAndEvent_eventIDAndTicketTypeAndCustomerIsNull(int vendorId, int eventID, String ticketType);

    List<Ticket> findAllByTicketPool_ticketPoolId(int ticketPoolID);
}
