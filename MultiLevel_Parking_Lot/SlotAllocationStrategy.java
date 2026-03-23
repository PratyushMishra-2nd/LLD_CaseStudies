package MultiLevel_Parking_Lot;
import java.util.List;

public interface SlotAllocationStrategy {
    ParkingSlot findSlot(SlotType type, String gateId, List<Level> levels);
}
