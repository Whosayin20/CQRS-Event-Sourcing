package writeside.infrastructure;


import org.springframework.stereotype.Repository;
import writeside.domain.Room.Room;
import writeside.domain.Room.RoomNumber;
import writeside.domain.repositories.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryImpl implements RoomRepository {
    private List<Room> roomList = new ArrayList<>();


    public RoomRepositoryImpl() {
        this.roomList.add(new Room(new RoomNumber("100"), 2));
        this.roomList.add(new Room(new RoomNumber("101"), 2));
        this.roomList.add(new Room(new RoomNumber("102"), 2));
        this.roomList.add(new Room(new RoomNumber("103"), 2));
        this.roomList.add(new Room(new RoomNumber("104"), 2));
        this.roomList.add(new Room(new RoomNumber("105"), 2));
    }

    public Optional<Room> findRoomByNo(String roomNumber) {
        return this.roomList.stream().filter(room -> room.getRoomNumber().equals(new RoomNumber(roomNumber))).findFirst();
    }
}
