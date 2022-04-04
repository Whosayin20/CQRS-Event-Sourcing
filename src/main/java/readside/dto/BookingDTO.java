package readside.dto;

import writeside.domain.Booking.BookingState;
import writeside.domain.Guest;
import writeside.domain.Room.RoomNumber;

import java.time.LocalDate;
import java.util.List;

public class BookingDTO {
    private String bookingNo;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestName;
    private String[] roomNumbers;
    private int nrOfGuests;

    public BookingDTO(String bookingNo, LocalDate arrivalDate, LocalDate departureDate, String guestName, String[] roomNumbers, int nrOfGuests) {
        this.bookingNo = bookingNo;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guestName = guestName;
        this.roomNumbers = roomNumbers;
        this.nrOfGuests = nrOfGuests;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public String[] getRoomNumbers() {
        return roomNumbers;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }
}
