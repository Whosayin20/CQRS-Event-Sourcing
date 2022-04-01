package writeside.domain.Booking;

import writeside.domain.Guest;
import writeside.domain.Room;
import java.time.LocalDate;

public class Booking {
    private BookingNo bookingNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private Guest guest;
    private Room room;
    private BookingState state;
    private int nrOfPeople;

    public Booking(BookingNo bookingNo, LocalDate startDate, LocalDate endDate, Guest guest, Room room, int nrOfPeople) {
        this.bookingNo = bookingNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.room = room;
        this.nrOfPeople = nrOfPeople;
        this.state = BookingState.ACTIVE;
    }


    public BookingNo getBookingNo() {
        return bookingNo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public BookingState getState() {
        return state;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }
}
