package eventside.domain;

import writeside.domain.Booking.BookingNo;

public class BookingCancelledEvent extends Event{
    private BookingNo bookingNo;

    public BookingCancelledEvent(BookingNo bookingNo){
        this.bookingNo = bookingNo;
    }

    public BookingNo getBookingNo(){
        return bookingNo;
    }
}
