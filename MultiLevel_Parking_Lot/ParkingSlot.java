package MultiLevel_Parking_Lot;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSlot {
    private String id;
    private SlotType type;
    private boolean isAvailable;
    private Map<String, Integer> distanceMap;
    private Lock lock;

    public ParkingSlot(String id, SlotType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
        this.distanceMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public String getId() { return id; }
    public SlotType getType() { return type; }
    public boolean isAvailable() { return isAvailable; }

    public void addDistance(String gateId, int distance) {
        distanceMap.put(gateId, distance);
    }

    public int getDistance(String gateId) {
        return distanceMap.getOrDefault(gateId, Integer.MAX_VALUE);
    }

    public boolean assignVehicle() {
        lock.lock();
        try {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void freeSlot() {
        lock.lock();
        try {
            isAvailable = true;
        } finally {
            lock.unlock();
        }
    }
}
