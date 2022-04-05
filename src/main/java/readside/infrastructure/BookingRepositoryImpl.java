package readside.infrastructure;

import org.springframework.stereotype.Repository;
import readside.dto.BookingDTO;
import readside.infrastructure.repositories.BookingRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private Set<BookingDTO> bookingDTOs = new HashSet<>();


    public void store(BookingDTO bookingDTO) {
        bookingDTOs.add(bookingDTO);
    }

    //@DepartureDate > ArrivalDate AND DepartureDate > @ArrivalDate
    public List<BookingDTO> getBookings(LocalDate arrivalDate, LocalDate departureDate) {
        return this.bookingDTOs.stream()
                .filter(bookingDTO -> departureDate.isAfter(bookingDTO.getArrivalDate()))
                .filter(bookingDTO ->  bookingDTO.getDepartureDate().isAfter(arrivalDate))
                .collect(Collectors.toList());
    }
}
