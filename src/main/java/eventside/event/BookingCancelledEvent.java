package eventside.event;

import writeside.domain.Booking.BookingNo;

public class BookingCancelledEvent extends Event {
    private BookingNo bookingNo;

    public BookingCancelledEvent(long timestamp, BookingNo bookingNo) {
        super(timestamp);
        this.bookingNo = bookingNo;
    }

    public BookingNo getBookingNo() {
        return bookingNo;
    }
}
