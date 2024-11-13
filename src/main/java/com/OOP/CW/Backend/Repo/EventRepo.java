package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {
    Optional<Event> findEventByEventNameAndEventDate(String eventName, LocalDate eventDateTime);
}
