package MultiLevel_Parking_Lot;
import java.util.UUID;

public class TicketFactory {
    public static Ticket create(ParkingSlot slot, Vehicle vehicle, String gateId) {
        return new Ticket(UUID.randomUUID().toString(), System.currentTimeMillis(), slot, vehicle, gateId);
    }
}
