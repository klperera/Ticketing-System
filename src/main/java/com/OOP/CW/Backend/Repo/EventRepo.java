package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {
    Optional<Event> findEventByEventName(String eventName);
    List<Event> findAllEventByOrganizer_OrganizerID(int organizerID);
}
