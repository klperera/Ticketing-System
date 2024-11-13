package com.OOP.CW.Backend.Service;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    private final EventRepo eventRepo;
    private final OrganizerRepo organizerRepo;

    @Autowired
    public EventService(EventRepo eventRepo, OrganizerRepo organizerRepo) {
        this.eventRepo = eventRepo;
        this.organizerRepo = organizerRepo;
    }

    public ResponseEntity<String> createEvent(Event NewEvent) {
        Optional<Event> event = eventRepo.findEventByEventNameAndEventDate(NewEvent.getEventName(), NewEvent.getEventDate());
        if (event.isPresent()) {
            return ResponseEntity.ok("Event is already exists");
        }
        else{
            Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(NewEvent.getOrganizer().getUserCredentials().getEmail());
            if (organizer.isPresent()) {
                eventRepo.save(NewEvent);
                return ResponseEntity.ok("Event registered successfully.");
            }
            else {
                return ResponseEntity.ok("Event could not be registered. Organizer not found.");
            }

        }
    }
}
