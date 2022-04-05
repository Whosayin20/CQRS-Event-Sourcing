package eventside.event;

import java.util.UUID;

public abstract class Event {
    private UUID id = UUID.randomUUID();
    private long timestamp;

    public Event(long timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{uid=" + id + ", timestamp=" + timestamp + ", type=" + getClass().getSimpleName() + '}';
    }
}