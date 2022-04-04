package eventside;

import eventside.event.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventRepository {

    private List<Event> events = new ArrayList<>();

    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void processEvent(Event event) {
        events.add(event);
        List<Subscriber> subs = subscribers.get(event.getClass().getSimpleName());
        for (Subscriber s : subs) {
            s.notify(event);
        }
    }

    public void subscribe(String host, String[] uri, String[] eventName) {
        System.out.print("host: " + host + " registered for follwing event(s): ");

        for (int i = 0; i < eventName.length; i++) {
            Subscriber s = new Subscriber(host, uri[i]);

            //If no subscriber under eventName is registered
            if (subscribers.get(eventName[i]) == null) {
                //Create new entry with eventName and new empty ArrayList
                subscribers.put(eventName[i], new ArrayList<>());
            }

            //Check if subscribers is already subscribed to that event
            if (!subscribers.get(eventName[i]).contains(s)) {
                //Add new Subscriber to the event
                subscribers.get(eventName[i]).add(new Subscriber(host, uri[i]));
            }

            System.out.print(eventName[i] + " ");
        }
        System.out.print("\n");
    }

    public void unsubscribe(String host, String uri, String eventName) {
        subscribers.get(eventName).remove(new Subscriber(host, uri));
    }
}
