package eventside.event;

public class BookingCancelledEvent extends Event {
    private String bookingNo;

    public BookingCancelledEvent(long timestamp, String bookingNo) {
        super(timestamp);
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }
}
