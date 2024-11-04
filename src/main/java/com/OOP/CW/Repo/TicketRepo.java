package com.OOP.CW.Repo;

import com.OOP.CW.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}
