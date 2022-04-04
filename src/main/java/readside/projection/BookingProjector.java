package readside.projection;

import eventside.event.BookingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import readside.dto.BookingDTO;
import readside.dto.FreeRoomDTO;
import readside.infrastructure.repositories.BookingRepository;
import readside.infrastructure.repositories.FreeRoomRepository;

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
    public void projectBookingCreatedEvent(BookingCreatedEvent bookingCreatedEvent) {
        //TODO: finish projection


        BookingDTO bookingDTO = new BookingDTO(
                bookingCreatedEvent.getBookingNo(),
                bookingCreatedEvent.getArrivalDate(),
                bookingCreatedEvent.getDepartureDate(),
                bookingCreatedEvent.getGuestName(),
                bookingCreatedEvent.getRoomNumber().toArray(new String[0]), //Convert list into Array
                bookingCreatedEvent.getNrOfGuests()
        );




        this.bookingRepository.store(bookingDTO);

    }

    public void projectBookingCancelledEvent(BookingCreatedEvent bookingCreatedEvent) {


    }

}
