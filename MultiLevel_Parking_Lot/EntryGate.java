package MultiLevel_Parking_Lot;
import java.util.List;

public class EntryGate {
    private String id;
    private SlotAllocationStrategy strategy;

    public EntryGate(String id, SlotAllocationStrategy strategy) {
        this.id = id;
        this.strategy = strategy;
    }

    public String getId() { return id; }

    public Ticket park(Vehicle vehicle, List<Level> levels) {
        // Try allocating a slot
        ParkingSlot slot = strategy.findSlot(vehicle.getType(), this.id, levels);
        if (slot == null) {
            System.out.println("No slots available for " + vehicle.getType());
            return null;
        }
        
        // Ensure thread-safe assignment
        if (slot.assignVehicle()) {
            for (Level level : levels) {
                if (level.hasSlot(slot)) {
                    level.claimSlot(slot);
                    break;
                }
            }
            return TicketFactory.create(slot, vehicle, this.id);
        } else {
            System.out.println("Slot allocation collision, please retry.");
            return null;
        }
    }
}
