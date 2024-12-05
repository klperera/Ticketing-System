package com.OOP.CW.Backend.Service;

import com.OOP.CW.Backend.Model.Event;
import com.OOP.CW.Backend.Model.EventDOT;
import com.OOP.CW.Backend.Model.TicketPool;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Repo.EventRepo;
import com.OOP.CW.Backend.Repo.TicketPoolRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.OrganizerRepo;
import com.OOP.CW.Backend.Repo.UsersRepository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService implements Runnable{

    private final EventRepo eventRepo;
    private final OrganizerRepo organizerRepo;
    private final TicketPoolRepo ticketPoolRepo;

    private Event event;
    private Response response;

    @Autowired
    public EventService(EventRepo eventRepo, OrganizerRepo organizerRepo, VendorRepo vendorRepo, TicketPoolRepo ticketPoolRepo) {
        this.eventRepo = eventRepo;
        this.organizerRepo = organizerRepo;
        this.ticketPoolRepo = ticketPoolRepo;
    }

    @Override
    public void run() {
        this.response = createEvent(getEvent());
    }

    public Response createEvent(Event NewEvent) {
        // check Event is already registered or not (using event name and organizer email)
        Optional<Event> event = eventRepo.findEventByEventName(NewEvent.getEventName());
        if (event.isPresent()) {
            EventDOT eventDOT = new EventDOT(event.get());
            return new Response(eventDOT,"Event is already exists");
            //return ResponseEntity.ok("Event is already exists");
            //return ResponseEntity.ok(event.get());
        }
        else{
            Optional<Organizer> organizer = organizerRepo.findByUserCredentials_Email(NewEvent.getOrganizer().getUserCredentials().getEmail());
            if (organizer.isPresent()) {
                TicketPool ticketPool = new TicketPool();
                NewEvent.setTicketPool(ticketPool);
                ticketPoolRepo.save(ticketPool);
                EventDOT eventDOT = new EventDOT(NewEvent);
                NewEvent.setOrganizer(organizer.get());
                eventRepo.save(NewEvent);
                return new Response(eventDOT,"Event has been created");
                //return ResponseEntity.ok("Event registered successfully.");
                //return ResponseEntity.ok(NewEvent);
            }
            else {
                return new Response(new Organizer(),"Organizer does not exist");
                //return ResponseEntity.badRequest().body("Event could not be registered. Organizer not found.");
                //return ResponseEntity.notFound().build();
            }
        }
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    public Event getEvent() {
        return event;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
