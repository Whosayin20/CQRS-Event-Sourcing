package writeside.domain;

import java.util.List;

public class Room {
    private String roomNumber;
    private List<RoomOccupancy> roomOccupancy;

    public Room(String roomNumber, List<RoomOccupancy> roomOccupancy) {
        this.roomNumber = roomNumber;
        this.roomOccupancy = roomOccupancy;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public List<RoomOccupancy> getRoomOccupancy() {
        return roomOccupancy;
    }
}
