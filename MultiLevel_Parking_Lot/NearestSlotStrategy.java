package MultiLevel_Parking_Lot;
import java.util.List;

public class NearestSlotStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot findSlot(SlotType type, String gateId, List<Level> levels) {
        ParkingSlot bestSlot = null;
        int minDistance = Integer.MAX_VALUE;

        for (Level level : levels) {
            ParkingSlot slot = level.getNearestSlot(type, gateId);
            if (slot != null && slot.getDistance(gateId) < minDistance) {
                minDistance = slot.getDistance(gateId);
                bestSlot = slot;
            }
        }
        
        return bestSlot;
    }
}
