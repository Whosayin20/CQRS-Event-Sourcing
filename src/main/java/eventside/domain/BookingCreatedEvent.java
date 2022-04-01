package eventside.domain;

import writeside.domain.Booking.BookingNo;
import writeside.domain.Room;
import writeside.domain.RoomNumber;

import java.time.LocalDate;

public class BookingCreatedEvent extends Event {
    private BookingNo bookingNo;
    private String guestName;
    private LocalDate startDate;
    private LocalDate endDate;
    private RoomNumber roomNumber;
    private int nrOfGuests;

    public BookingCreatedEvent(BookingNo bookingNo, String guestName, LocalDate startDate, LocalDate endDate, RoomNumber roomNumber, int nrOfGuests){
        this.bookingNo = bookingNo;
        this.guestName = guestName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.roomNumber = roomNumber;
        this.nrOfGuests = nrOfGuests;
    }

    public BookingNo getBookingNo(){
        return bookingNo;
    }

    public String getGuestName(){
        return guestName;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public RoomNumber getRoomNumber(){
        return roomNumber;
    }

    public int getNrOfGuests(){
        return nrOfGuests;
    }
}
