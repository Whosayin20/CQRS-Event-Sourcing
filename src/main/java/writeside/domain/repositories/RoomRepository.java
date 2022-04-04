package writeside.domain.repositories;

import writeside.domain.Room.Room;

import java.util.Optional;

public interface RoomRepository {
    Optional<Room> findRoomByNo(String roomNumber);
}
