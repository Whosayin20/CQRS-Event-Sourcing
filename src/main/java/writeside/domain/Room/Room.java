package writeside.domain.Room;

public class Room {
    private RoomNumber roomNumber;
    private int capacity;

    public Room(RoomNumber roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
