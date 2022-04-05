package eventside;

import eventside.event.Event;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class Subscriber {
    private final String HOST;
    private final String URI;


    public Subscriber(String host, String uri) {
        this.HOST = host;
        this.URI = uri;
    }

    public void notify(Event e) {
        WebClient localApiClient = WebClient.create(this.HOST);

        System.out.println("publishing: " + e);
        localApiClient
                .post()
                .uri(this.URI)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(e), Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(HOST, that.HOST) && Objects.equals(URI, that.URI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HOST, URI);
    }
}
