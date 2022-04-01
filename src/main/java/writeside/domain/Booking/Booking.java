package writeside.domain.Booking;

import writeside.domain.Guest;
import writeside.domain.Room;
import writeside.domain.RoomNumber;

import java.time.LocalDate;

public class Booking {
    private BookingNo bookingNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private Guest guest;
    private Room room;
    private BookingState state;
    private int nrOfPeople;

    private Booking(BookingNo bookingNo, LocalDate startDate, LocalDate endDate, Guest guest, Room room, int nrOfPeople) {
        this.bookingNo = bookingNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.room = room;
        this.nrOfPeople = nrOfPeople;
        this.state = BookingState.ACTIVE;
    }

    public static Booking create(BookingNo bookingNo, LocalDate startDate, LocalDate endDate, Guest guest, Room room, int nrOfPeople) {
        //Pruefen, ob die Anzahl der Personen in das Zimmer passt
        if(room.getCapacity() < nrOfPeople) {
            throw new IllegalArgumentException("The number of people are too high for this room!");
        }

        //starDat < endDate
        if(startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
            throw new IllegalArgumentException("The check-out date must be after the check-in date!");
        }

        //Pruefen, ob Check-in Datum in der Vergangenheit liegt
        if(startDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The check-in date can't be in the past!");
        }

        //Pruefen, ob die Anzahl der Gäste mind. 1 ist
        if(nrOfPeople < 1){
            throw new IllegalArgumentException("There must be at least one guest per booking!");
        }

        return new Booking(bookingNo, startDate, endDate, guest, room, nrOfPeople);
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

    public RoomNumber getRoomNumber() {
        return room.getRoomNumber();
    }

    public BookingState getState() {
        return state;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }
}
