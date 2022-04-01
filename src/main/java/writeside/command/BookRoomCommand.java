package writeside.command;

import writeside.domain.Booking.BookingNo;
import writeside.domain.RoomNumber;

import java.time.LocalDate;

public class BookRoomCommand {
    private BookingNo bookingNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private String guestName;
    private int nrOfGuests;
    private RoomNumber roomNumber;

    public BookRoomCommand(BookingNo bookingNo, LocalDate startDate, LocalDate endDate, String guestName, int nrOfGuests, RoomNumber roomNumber) {
        this.bookingNo = bookingNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestName = guestName;
        this.nrOfGuests = nrOfGuests;
        this.roomNumber = roomNumber;
    }

    public BookingNo getBookingNo(){
        return bookingNo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }
}
