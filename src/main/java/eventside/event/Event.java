package eventside.event;

import java.util.UUID;

public abstract class Event {
    private UUID id = UUID.randomUUID();
    private long timestamp;

    public Event() {

    }

    public Event(long timestamp) {
        this.timestamp = timestamp;
    }

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
        return "Event{uid=" + id + ", timestamp=" + timestamp + ", type=" + getClass().getSimpleName() + '}';
    }
}


//public class Event {
//
//    private String customer;
//    private long timestamp;
//    private String content;
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "Event{" +
//                "customer='" + customer + '\'' +
//                ", timestamp=" + timestamp +
//                ", content='" + content + '\'' +
//                '}';
//    }
//}