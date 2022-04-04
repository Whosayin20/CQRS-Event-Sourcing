package writeside.domain.Room;
;
import writeside.domain.Booking.BookingNo;

import java.time.LocalDate;
import java.util.List;

public class Room {
    private RoomNumber roomNumber;
    private int capacity;
    private List<Booking> bookings;

    public Room(RoomNumber roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public boolean isBookable(LocalDate startDate, LocalDate endDate) {
        for(Booking b : bookings) {
            if(startDate.compareTo(b.getArrivalDate()) * endDate.compareTo(b.getDepartureDate()) >= 0) { return false; }
        }
        return true;
    }


    public void bookRoom(Booking booking) {
        this.bookings.forEach(b -> {
            if(b.getBookingNo().equals(booking.getBookingNo())) {
                throw new IllegalArgumentException("Booking has already booked the room");
            }
        });

        //if(!this.roomNumber.equals(booking.getRoom().getRoomNumber())) { throw new IllegalArgumentException("Booking is not for this room"); }

        this.bookings.add(booking);
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
