package writeside.application;

import org.springframework.stereotype.Service;
import writeside.command.BookRoomCommand;
import writeside.command.CancelBookingCommand;


@Service
public interface BookingService {
    boolean bookRoom(BookRoomCommand bookRoomCommand);

    boolean cancelBooking(CancelBookingCommand cancelBookingCommand);
}
