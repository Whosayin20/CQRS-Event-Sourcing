package readside.infrastructure;

import org.springframework.stereotype.Repository;
import readside.dto.RoomDTO;
import readside.infrastructure.repositories.FreeRoomRepository;
import java.time.LocalDate;
import java.util.*;

@Repository
public class RoomRepositoryImpl implements FreeRoomRepository {
    private Set<RoomDTO> roomDTOS = new HashSet<>();

    public RoomRepositoryImpl() {
        this.roomDTOS.add(new RoomDTO("100", 2));
        this.roomDTOS.add(new RoomDTO("101", 2));
        this.roomDTOS.add(new RoomDTO("102", 2));
        this.roomDTOS.add(new RoomDTO("103", 3));
        this.roomDTOS.add(new RoomDTO("104", 4));
        this.roomDTOS.add(new RoomDTO("105", 5));
    }

    @Override
    public List<RoomDTO> getFreeRooms(LocalDate from, LocalDate to, int nrOfGuests) {
        List<RoomDTO> freeRooms = new ArrayList<>();
        boolean isFree = false;
        for(RoomDTO roomDTO : roomDTOS) {
            for(Map.Entry<LocalDate, LocalDate> entry : roomDTO.getRoomOccupancies().entrySet()) {
                if(!from.isBefore(entry.getKey()) && !to.isBefore(entry.getKey()) &&
                   !from.isBefore(entry.getValue()) && !to.isBefore(entry.getValue())
                   && roomDTO.getCapacity() >= nrOfGuests) {
                    isFree = true;
                } else {
                    isFree = false;
                    break;
                }
            }
            if(isFree) {
                freeRooms.add(roomDTO);
            }
        }
        return freeRooms;
    }

    @Override
    public RoomDTO getRoomByNo(String roomNumber) {
        return this.roomDTOS.stream().filter(roomDTO -> roomDTO.getRoomNumber().equals(roomNumber)).findFirst().orElseThrow();
    }

    @Override
    public void updateOccupancy(RoomDTO room) {
        this.roomDTOS.add(room);
    }
}