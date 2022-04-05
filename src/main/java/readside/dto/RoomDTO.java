package readside.dto;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class RoomDTO {
    private String roomNumber;
    private int capacity;
    private HashMap<LocalDate, LocalDate> roomOccupancies;

    public RoomDTO(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomOccupancies = new HashMap<>();
        //Set an initial roomOccupancy in order to get the conditionals to work
        this.roomOccupancies.put(LocalDate.of(2022,1,1), LocalDate.of(2022,1,2));
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<LocalDate, LocalDate> getRoomOccupancies() {
        return roomOccupancies;
    }

    public void addRoomOccupancy(LocalDate occupiedFrom, LocalDate occupiedTo) {
        this.roomOccupancies.put(occupiedFrom, occupiedTo);
    }

    public void cancelRoomOccupancy(LocalDate occupiedFrom, LocalDate occupiedTo) {
        this.roomOccupancies.remove(occupiedFrom, occupiedTo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return capacity == roomDTO.capacity && Objects.equals(roomNumber, roomDTO.roomNumber) && Objects.equals(roomOccupancies, roomDTO.roomOccupancies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, capacity, roomOccupancies);
    }
}
