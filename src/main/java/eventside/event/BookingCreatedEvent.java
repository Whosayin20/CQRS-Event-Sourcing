package eventside.event;

import java.time.LocalDate;
import java.util.List;

public class BookingCreatedEvent extends Event {
    private String bookingNo;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestName;
    private List<String> roomNumbers;
    private int nrOfGuests;

    public BookingCreatedEvent(long timestamp, String bookingNo, LocalDate arrivalDate, LocalDate departureDate, String guestName, List<String> roomNumbers, int nrOfGuests) {
        super(timestamp);
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

    public List<String> getRoomNumbers() {
        return roomNumbers;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }
}
