package readside.projection;

import eventside.event.BookingCancelledEvent;
import eventside.event.BookingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.webjars.NotFoundException;
import readside.dto.BookingDTO;
import readside.dto.RoomDTO;
import readside.infrastructure.repositories.BookingRepository;
import readside.infrastructure.repositories.FreeRoomRepository;

import java.util.Optional;

@Component
public class BookingProjector implements Projection {

    @Autowired
    private FreeRoomRepository freeRoomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    //Subscribe to relevant events
    public BookingProjector() {
        WebClient localApiClient = WebClient.create("http://localhost:8080");
        localApiClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/subscribe/")
                        .queryParam("host", "http://localhost:8082")
                        .queryParam("uri", "/bookingCreated/")
                        .queryParam("uri", "/bookingCancelled/")
                        .queryParam("eventName", "BookingCreatedEvent")
                        .queryParam("eventName", "BookingCancelledEvent")
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }


    //Projection: what is the current state derived from the event stream?
    public void projectBookingCreatedEvent(BookingCreatedEvent event) {
        //Update of the rooms occupied dates, that have been booked
        event.getRoomNumbers()
                .forEach(roomNo -> this.freeRoomRepository
                        .getRoomByNo(roomNo)
                        .addRoomOccupancy(event.getArrivalDate(), event.getDepartureDate()));

        BookingDTO bookingDTO = new BookingDTO(
                event.getBookingNo(),
                event.getArrivalDate(),
                event.getDepartureDate(),
                event.getGuestName(),
                event.getRoomNumbers().toArray(new String[0]), //Convert list into Array
                event.getNrOfGuests()
        );

        this.bookingRepository.store(bookingDTO);
    }

    public void projectBookingCancelledEvent(BookingCancelledEvent event) {
        try {
            BookingDTO booking = this.bookingRepository.bookingByNo(event.getBookingNo()).orElseThrow(() -> new NotFoundException("Booking not found"));

            for (int i = 0; i < booking.getRoomNumbers().length; i++) {
                RoomDTO roomDTO = this.freeRoomRepository.getRoomByNo(booking.getRoomNumbers()[i]);
                roomDTO.cancelRoomOccupancy(booking.getArrivalDate(), booking.getDepartureDate());
                this.freeRoomRepository.updateOccupancy(roomDTO);
            }

            this.bookingRepository.cancelBooking(booking);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
