package writeside;

import eventside.event.BookingCancelledEvent;
import eventside.event.BookingCreatedEvent;
import eventside.event.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventPublisher {

    private final WebClient localApiClient = WebClient.create("http://localhost:8080");

    public EventPublisher() {
    }


    public Boolean publishBookingCreatedEvent(BookingCreatedEvent event) {
        System.out.println("publishing: " + event);
        return localApiClient
                .post()
                .uri("/createBooking/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishCancelBookingEvent(BookingCancelledEvent event){
        System.out.println("publishing: " + event);
        return localApiClient
                .post()
                .uri("/cancelBooking/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
