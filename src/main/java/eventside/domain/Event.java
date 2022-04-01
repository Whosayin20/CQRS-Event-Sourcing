package eventside.domain;

import java.util.UUID;

public abstract class Event {
    private UUID id = UUID.randomUUID();
    private long timestamp;

    public UUID getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Event{id=" + id + ", timestamp=" + timestamp + "type=" + getClass().getSimpleName() + '}';
    }
}
