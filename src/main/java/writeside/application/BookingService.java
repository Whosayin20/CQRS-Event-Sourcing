package writeside.application;

import org.springframework.stereotype.Service;
import writeside.command.BookRoomCommand;


@Service
public interface BookingService {
    boolean bookRoom(BookRoomCommand bookRoomCommand);
}
