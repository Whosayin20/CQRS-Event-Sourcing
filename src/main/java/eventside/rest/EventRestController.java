package eventside.rest;

import eventside.EventRepository;
import eventside.event.BookingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @PostMapping(value = "/createBooking", consumes = "application/json", produces = "application/json")
    public boolean bookingCreated(@RequestBody BookingCreatedEvent event) {
        System.out.println("Event received: " + event);
        repository.processEvent(event);
        return true;
    }

    @PostMapping(value = "/subscribe")
    public boolean subscribe(@RequestParam String host, @RequestParam String[] uri, @RequestParam String[] eventName) {
        repository.subscribe(host, uri, eventName);
        return true;
    }

    @PostMapping(value = "/unsubscribe")
    public boolean unsubscribe(@RequestParam String host, @RequestParam String uri, @RequestParam String eventName) {
        repository.unsubscribe(host, uri, eventName);
        return true;
    }
}
