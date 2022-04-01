package writeside.repository;

import writeside.domain.Booking.Booking;

import java.util.ArrayList;
import java.util.List;

public class WriteRepository {
    private List<Booking> bookingList = new ArrayList<>();

    public void store(Booking booking) {
        this.bookingList.add(booking);
    }

}
