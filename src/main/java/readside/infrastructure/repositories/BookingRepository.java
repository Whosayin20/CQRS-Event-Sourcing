package readside.infrastructure.repositories;

import readside.dto.BookingDTO;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository {

    void store(BookingDTO bookingDTO);

    List<BookingDTO> getBookings(LocalDate arrivalDate, LocalDate departureDate);


}
