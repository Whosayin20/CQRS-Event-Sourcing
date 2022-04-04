package readside.rest;

import eventside.event.BookingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import readside.dto.BookingDTO;
import readside.projection.Projection;
import readside.infrastructure.repositories.BookingRepository;
import readside.infrastructure.repositories.FreeRoomRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ReadRestController {

    @Autowired
    private Projection projection;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FreeRoomRepository freeRoomRepository;


    @PostMapping(value = "/bookingCreated", consumes = "application/json", produces = "application/json")
    public boolean bookRoom(@RequestBody BookingCreatedEvent bookingCreatedEvent) {
        System.out.println("Received " + bookingCreatedEvent);
        projection.projectBookingCreatedEvent(bookingCreatedEvent);
        return true;
    }



    @GetMapping(value = "/freeRooms")
    public boolean freeRooms(@RequestParam String arrivalDateStr, @RequestParam String departureDateStr, @RequestParam int nrOfGuests) {
        LocalDate arrivalDate = LocalDate.parse(arrivalDateStr, DateTimeFormatter.ISO_DATE);
        LocalDate departureDate = LocalDate.parse(departureDateStr, DateTimeFormatter.ISO_DATE);


        return true;
    }

    @GetMapping(value = "/bookings")
    public List<BookingDTO> bookings(@RequestParam String arrivalDateStr, @RequestParam String departureDateStr) {
        LocalDate arrivalDate = LocalDate.parse(arrivalDateStr, DateTimeFormatter.ISO_DATE);
        LocalDate departureDate = LocalDate.parse(departureDateStr, DateTimeFormatter.ISO_DATE);
        return this.bookingRepository.getBookings(arrivalDate, departureDate);
    }


}
