package writeside.application;

import eventside.event.BookingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import writeside.EventPublisher;
import writeside.command.BookRoomCommand;
import writeside.domain.Booking.Booking;
import writeside.domain.Booking.BookingNo;
import writeside.domain.Room.RoomNumber;
import writeside.domain.repositories.BookingRepository;
import writeside.domain.repositories.RoomRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public boolean bookRoom(BookRoomCommand bookRoomCommand) {
        List<String> roomNumbers = bookRoomCommand.getRoomNumbers();

        int roomsCapacity = 0;
        Booking booking;
        try {
            //Check if room numbers exists
            //Check, if the number of guests fit in the room
            for (String roomNumber : roomNumbers) {
                roomsCapacity += this.roomRepository.findRoomByNo(roomNumber)
                        .orElseThrow(() -> new IllegalArgumentException("Room Number " + roomNumber + " does not exist"))
                        .getCapacity();
            }
            if (roomsCapacity < bookRoomCommand.getNrOfGuests()) {
                throw new IllegalArgumentException("The number of people are too high for this room!");
            }

            //Command --> Domain Object
            booking = Booking.create(
                    new BookingNo(UUID.randomUUID().toString()),
                    bookRoomCommand.getArrivalDate(),
                    bookRoomCommand.getDepartureDate(),
                    bookRoomCommand.getGuestName(),
                    bookRoomCommand.getRoomNumbers().stream().map(RoomNumber::new).collect(Collectors.toList()),
                    bookRoomCommand.getNrOfGuests()
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        this.bookingRepository.store(booking);

        //Domain Object --> Event
        BookingCreatedEvent bookingCreatedEvent = new BookingCreatedEvent(
                System.currentTimeMillis(),
                booking.getBookingNo().getBookingNo(),
                booking.getArrivalDate(),
                booking.getDepartureDate(),
                booking.getGuest().getName(),
                booking.getRoomNumbers().stream().map(RoomNumber::getNumber).collect(Collectors.toList()),
                booking.getNrOfGuests()
        );

        //Publish Event
        this.eventPublisher.publishBookingCreatedEvent(bookingCreatedEvent);
        return true;
    }
}
