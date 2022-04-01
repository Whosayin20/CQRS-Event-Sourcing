package writeside.commandHandler;

import eventside.domain.BookingCreatedEvent;
import writeside.command.BookRoomCommand;

public class BookingHandler {


    public void handleBookRoomCommand(BookRoomCommand bookRoomCommand) {

        //Command --> Event
        BookingCreatedEvent bookingCreatedEvent = new BookingCreatedEvent(
                bookRoomCommand.getBookingNo(),
                bookRoomCommand.getGuestName(),
                bookRoomCommand.getStartDate(),
                bookRoomCommand.getEndDate(),
                bookRoomCommand.getRoomNumber(),
                bookRoomCommand.getNrOfGuests()
        );




    }

}
