package writeside.domain.repositories;

import writeside.domain.Booking.Booking;
import writeside.domain.Booking.BookingNo;

import java.util.Optional;

public interface BookingRepository {

    void store(Booking booking);

    Optional<Booking> bookingByNo(BookingNo bookingNo);
}
