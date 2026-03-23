package MultiLevel_Parking_Lot;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingLot {
    private List<Level> levels;
    private Map<String, EntryGate> gates;

    public ParkingLot(List<Level> levels, List<EntryGate> gatesList) {
        this.levels = levels;
        this.gates = new HashMap<>();
        for (EntryGate gate : gatesList) {
            this.gates.put(gate.getId(), gate);
        }
    }

    public Ticket park(Vehicle vehicle, String gateId) {
        EntryGate gate = gates.get(gateId);
        if (gate == null) throw new IllegalArgumentException("Invalid Gate");
        return gate.park(vehicle, levels);
    }

    public double exit(Ticket ticket) {
        PricingStrategy strategy = PricingStrategyFactory.get(ticket.getSlot().getType());
        double price = strategy.calculate(ticket);
        
        ticket.getSlot().freeSlot();
        
        for (Level level : levels) {
            if (level.hasSlot(ticket.getSlot())) {
                level.freeSlot(ticket.getSlot());
                break;
            }
        }
        return price;
    }
}
