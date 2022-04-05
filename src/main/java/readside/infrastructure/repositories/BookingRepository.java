package readside.infrastructure.repositories;

import readside.dto.BookingDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {

    void store(BookingDTO bookingDTO);

    List<BookingDTO> getBookings(LocalDate arrivalDate, LocalDate departureDate);

    Optional<BookingDTO> bookingByNo(String bookingNo);

    void cancelBooking(BookingDTO booking);
}
