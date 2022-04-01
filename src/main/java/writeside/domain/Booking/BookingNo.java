package writeside.domain.Booking;

import java.util.Objects;

public class BookingNo {
    private String bookingNo;

    public BookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }


    public String getBookingNo() {
        return bookingNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingNo bookingNo1 = (BookingNo) o;
        return Objects.equals(bookingNo, bookingNo1.bookingNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingNo);
    }
}
