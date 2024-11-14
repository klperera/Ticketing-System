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

    public ResponseEntity<EntityResponse> createEvent(Event NewEvent) {
        // check Event is already registered or not (using event name and organizer email)
        Optional<Event> event = eventRepo.findEventByEventName(NewEvent.getEventName());
        if (event.isPresent()) {
            return ResponseEntity.ok(new EntityResponse(event,"Event is already exists"));
            //return ResponseEntity.ok("Event is already exists");
            //return ResponseEntity.ok(event.get());
        }
        else{
            Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(NewEvent.getOrganizer().getUserCredentials().getEmail());
            if (organizer.isPresent()) {
                NewEvent.setOrganizer(organizer.get());
                eventRepo.save(NewEvent);
                return ResponseEntity.ok(new EntityResponse(NewEvent,"Event has been created"));
                //return ResponseEntity.ok("Event registered successfully.");
                //return ResponseEntity.ok(NewEvent);
            }
            else {
                return ResponseEntity.ok(new EntityResponse(new Event(),"Organizer does not exist"));
                //return ResponseEntity.badRequest().body("Event could not be registered. Organizer not found.");
                //return ResponseEntity.notFound().build();
            }

        }
    }
}
