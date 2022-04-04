package writeside.command;

import java.time.LocalDate;
import java.util.List;

public class BookRoomCommand {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestName;
    private int nrOfGuests;
    private List<String> roomNumbers;

    private BookRoomCommand(LocalDate arrivalDate, LocalDate departureDate, String guestName, int nrOfGuests, List<String> roomNumbers) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guestName = guestName;
        this.nrOfGuests = nrOfGuests;
        this.roomNumbers = roomNumbers;
    }

    //Validating Simple Input Data
    public static BookRoomCommand create(LocalDate arrivalDate, LocalDate departureDate, String guestName, int nrOfGuests, List<String> roomNumber) {
        try {
            if(arrivalDate.isAfter(departureDate) || departureDate.isBefore(arrivalDate)) {
                throw new IllegalArgumentException("Arrival date must be after Departure date");
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new BookRoomCommand(arrivalDate, departureDate, guestName, nrOfGuests, roomNumber);
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNrOfGuests() {
        return nrOfGuests;
    }

    public List<String> getRoomNumbers() {
        return roomNumbers;
    }
}
