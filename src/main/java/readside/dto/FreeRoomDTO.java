package readside.dto;


public class FreeRoomDTO {
    private String roomNumber;
    private int capacity;

    public FreeRoomDTO(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
