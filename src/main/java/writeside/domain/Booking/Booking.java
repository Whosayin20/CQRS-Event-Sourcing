package writeside.domain.Booking;

import writeside.domain.Guest;
import writeside.domain.Room.RoomNumber;
import java.time.LocalDate;
import java.util.List;


public class Booking {
    private BookingNo bookingNo;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private Guest guest;
    private List<RoomNumber> rooms;
    private BookingState state;
    private int nrOfGuests;

    private Booking(BookingNo bookingNo, LocalDate arrivalDate, LocalDate departureDate, Guest guest, List<RoomNumber> rooms, int nrOfGuests) {
        this.bookingNo = bookingNo;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guest = guest;
        this.rooms = rooms;
        this.nrOfGuests = nrOfGuests;
        this.state = BookingState.ACTIVE;
    }


    //Validate Business Logic
    public static Booking create(BookingNo bookingNo, LocalDate arrivalDate, LocalDate departureDate, String guestName, List<RoomNumber> rooms, int nrOfGuests) throws IllegalArgumentException{
        //Check, if the number of people is > 1
        if(nrOfGuests < 1){
            throw new IllegalArgumentException("There must be at least one guest per booking");
        }
        return new Booking(bookingNo, arrivalDate, departureDate, new Guest(guestName), rooms, nrOfGuests);
    }

    public BookingNo getBookingNo() {
        return bookingNo;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public List<RoomNumber> getRoomNumbers() {
        return rooms;
    }

    public BookingState getState() {
        return state;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }
}
