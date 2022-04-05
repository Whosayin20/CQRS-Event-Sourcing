package writeside.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import writeside.application.BookingService;
import writeside.command.BookRoomCommand;
import writeside.command.CancelBookingCommand;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class WriteRestController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/createbooking")
    public boolean bookRoom(@RequestParam String arrivalDateStr,
                            @RequestParam String departureDateStr,
                            @RequestParam String guestName,
                            @RequestParam int nrOfGuests,
                            @RequestParam String[] roomNumbers) {

        LocalDate arrivalDate = LocalDate.parse(arrivalDateStr, DateTimeFormatter.ISO_DATE);
        LocalDate departureDate = LocalDate.parse(departureDateStr, DateTimeFormatter.ISO_DATE);

        return bookingService.bookRoom(BookRoomCommand.create(arrivalDate, departureDate, guestName, nrOfGuests, Arrays.stream(roomNumbers).collect(Collectors.toList())));
    }


    @PostMapping(value = "/cancelBooking")
    public boolean cancelBooking(@RequestParam String bookingNo) {
        return bookingService.cancelBooking(new CancelBookingCommand(bookingNo));
    }
}
