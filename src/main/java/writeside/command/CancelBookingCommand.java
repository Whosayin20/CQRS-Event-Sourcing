package writeside.command;

import writeside.domain.Booking.BookingNo;

public class CancelBookingCommand {
    private String bookingNo;

    public CancelBookingCommand(String bookingNo){
        this.bookingNo = bookingNo;
    }

    public String getBookingNo(){
        return bookingNo;
    }
}

