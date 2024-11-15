package com.OOP.CW.Backend.Service;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService{

    private final EventRepo eventRepo;
    private final OrganizerRepo organizerRepo;
    private final VendorRepo vendorRepo;

    @Autowired
    public EventService(EventRepo eventRepo, OrganizerRepo organizerRepo, VendorRepo vendorRepo) {
        this.eventRepo = eventRepo;
        this.organizerRepo = organizerRepo;
        this.vendorRepo = vendorRepo;
    }

    public ResponseEntity<Response> createEvent(Event NewEvent) {
        // check Event is already registered or not (using event name and organizer email)
        Optional<Event> event = eventRepo.findEventByEventName(NewEvent.getEventName());
        if (event.isPresent()) {
            return ResponseEntity.ok(new Response(event,"Event is already exists"));
            //return ResponseEntity.ok("Event is already exists");
            //return ResponseEntity.ok(event.get());
        }
        else{
            Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(NewEvent.getOrganizer().getUserCredentials().getEmail());
            if (organizer.isPresent()) {
                NewEvent.setOrganizer(organizer.get());
                eventRepo.save(NewEvent);
                return ResponseEntity.ok(new Response(NewEvent,"Event has been created"));
                //return ResponseEntity.ok("Event registered successfully.");
                //return ResponseEntity.ok(NewEvent);
            }
            else {
                return ResponseEntity.ok(new Response(new Event(),"Organizer does not exist"));
                //return ResponseEntity.badRequest().body("Event could not be registered. Organizer not found.");
                //return ResponseEntity.notFound().build();
            }

        }
    }

    public ResponseEntity<Response> allEvents(UserCredentials userCredentials) {
        Optional<Vendor> vendor = vendorRepo.findByUserCredentials_EmailAndUserCredentials_Password(userCredentials.getEmail(), userCredentials.getPassword());
        if (vendor.isPresent()) {
            return ResponseEntity.ok(new Response(eventRepo.findAll(),"All events have been found"));
        }else{
            return ResponseEntity.ok(new Response(new Event(),"incorrect vendor details"));
        }
    }

}
