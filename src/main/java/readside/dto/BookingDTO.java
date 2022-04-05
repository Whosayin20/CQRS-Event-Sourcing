package readside.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDTO that = (BookingDTO) o;
        return nrOfGuests == that.nrOfGuests && Objects.equals(bookingNo, that.bookingNo) && Objects.equals(arrivalDate, that.arrivalDate) && Objects.equals(departureDate, that.departureDate) && Objects.equals(guestName, that.guestName) && Arrays.equals(roomNumbers, that.roomNumbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookingNo, arrivalDate, departureDate, guestName, nrOfGuests);
        result = 31 * result + Arrays.hashCode(roomNumbers);
        return result;
    }
}
