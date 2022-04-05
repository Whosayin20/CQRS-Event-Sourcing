package writeside.infrastructure;

import org.springframework.stereotype.Repository;
import writeside.domain.Booking.Booking;
import writeside.domain.Booking.BookingNo;
import writeside.domain.repositories.BookingRepository;
import java.util.*;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private Set<Booking> bookingList = new HashSet<>();

    public void store(Booking booking) {
        this.bookingList.add(booking);
    }

    public Optional<Booking> bookingByNo(BookingNo bookingNo) {
        return this.bookingList.stream().filter(booking -> booking.getBookingNo().equals(bookingNo)).findFirst();
    }

}
