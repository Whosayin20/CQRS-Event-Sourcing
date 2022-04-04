package readside.projection;

import eventside.event.BookingCreatedEvent;

public interface Projection {
    void projectBookingCreatedEvent(BookingCreatedEvent bookingCreatedEvent);

    void projectBookingCancelledEvent(BookingCreatedEvent bookingCreatedEvent);

}
