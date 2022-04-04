package writeside.domain.Room;

import java.util.Objects;

public class RoomNumber {
    private String number;

    public RoomNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomNumber that = (RoomNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
