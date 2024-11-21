package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.TicketPool;
import com.OOP.CW.Backend.Model.Tickets.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPoolRepo extends JpaRepository<Ticket, Integer> {
    void save(TicketPool ticketPool);
}
