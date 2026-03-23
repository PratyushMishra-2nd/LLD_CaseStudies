package MultiLevel_Parking_Lot;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Level {
    private String id;
    private Map<String, Map<SlotType, TreeSet<ParkingSlot>>> availableSlots;
    private List<String> gateIds;
    private Set<ParkingSlot> allSlots;

    public Level(String id, List<String> gateIds) {
        this.id = id;
        this.gateIds = gateIds;
        this.allSlots = new HashSet<>();
        availableSlots = new ConcurrentHashMap<>();
        
        for (String gate : gateIds) {
            Map<SlotType, TreeSet<ParkingSlot>> typeMap = new HashMap<>();
            for (SlotType type : SlotType.values()) {
                typeMap.put(type, new TreeSet<>(Comparator.comparingInt((ParkingSlot s) -> s.getDistance(gate)).thenComparing(ParkingSlot::getId)));
            }
            availableSlots.put(gate, typeMap);
        }
    }

    public boolean hasSlot(ParkingSlot slot) {
        return allSlots.contains(slot);
    }

    public void addSlot(ParkingSlot slot) {
        allSlots.add(slot);
        for (String gate : gateIds) {
            availableSlots.get(gate).get(slot.getType()).add(slot);
        }
    }

    public void claimSlot(ParkingSlot slot) {
        for (String gate : gateIds) {
            synchronized(availableSlots.get(gate).get(slot.getType())) {
                availableSlots.get(gate).get(slot.getType()).remove(slot);
            }
        }
    }

    public void freeSlot(ParkingSlot slot) {
        for (String gate : gateIds) {
            synchronized(availableSlots.get(gate).get(slot.getType())) {
                availableSlots.get(gate).get(slot.getType()).add(slot);
            }
        }
    }

    public ParkingSlot getNearestSlot(SlotType type, String gateId) {
        TreeSet<ParkingSlot> slots = availableSlots.get(gateId).get(type);
        synchronized(slots) {
            return slots.isEmpty() ? null : slots.first();
        }
    }
}
