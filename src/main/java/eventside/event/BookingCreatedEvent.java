package eventside.event;

import java.time.LocalDate;
import java.util.List;

public class BookingCreatedEvent extends Event {
    private String bookingNo;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestName;
    private List<String> roomNumber;
    private int nrOfGuests;

    public BookingCreatedEvent(long timestamp, String bookingNo, LocalDate arrivalDate, LocalDate departureDate, String guestName, List<String> roomNumber, int nrOfGuests) {
        super(timestamp);
        this.bookingNo = bookingNo;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
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

    public List<String> getRoomNumber() {
        return roomNumber;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }
}
