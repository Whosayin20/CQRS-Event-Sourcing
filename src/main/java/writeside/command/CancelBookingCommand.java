package writeside.command;

import writeside.domain.Booking.BookingNo;

public class CancelBookingCommand {
    private BookingNo bookingNo;

    public CancelBookingCommand(BookingNo bookingNo){
        this.bookingNo = bookingNo;
    }

    public BookingNo getBookingNo(){
        return bookingNo;
    }
}

