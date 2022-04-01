package writeside.domain;
;
import writeside.domain.Booking.BookingNo;

import java.util.List;

public class Room {
    private String roomNumber;
    private int capacity;
    private List<BookingNo> bookings;

    public Room(String roomNumber, int capacity, List<BookingNo> bookings) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.bookings = bookings;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<BookingNo> getBooking() {
        return bookings;
    }
}
