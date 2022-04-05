package readside.infrastructure.repositories;

import readside.dto.RoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface FreeRoomRepository {

    List<RoomDTO> getFreeRooms(LocalDate from, LocalDate to, int nrOfGuests);

    RoomDTO getRoomByNo(String roomNumber);

    void updateOccupancy(RoomDTO room);
}
