package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Tickets.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}
