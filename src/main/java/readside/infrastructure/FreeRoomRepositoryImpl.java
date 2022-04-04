package readside.infrastructure;

import org.springframework.stereotype.Repository;
import readside.dto.FreeRoomDTO;
import readside.infrastructure.repositories.FreeRoomRepository;

import java.util.ArrayList;

@Repository
public class FreeRoomRepositoryImpl implements FreeRoomRepository {
    private ArrayList<FreeRoomDTO> freeRoomDTOS = new ArrayList<>();

    @Override
    public void store(FreeRoomDTO freeRoomDTO) {
        this.freeRoomDTOS.add(freeRoomDTO);
    }
}
