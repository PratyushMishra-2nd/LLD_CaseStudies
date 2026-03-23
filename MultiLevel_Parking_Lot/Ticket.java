package MultiLevel_Parking_Lot;

public class Ticket {
    private String id;
    private long entryTime;
    private ParkingSlot slot;
    private Vehicle vehicle;
    private String gateId;

    public Ticket(String id, long entryTime, ParkingSlot slot, Vehicle vehicle, String gateId) {
        this.id = id;
        this.entryTime = entryTime;
        this.slot = slot;
        this.vehicle = vehicle;
        this.gateId = gateId;
    }

    public long getEntryTime() { return entryTime; }
    public ParkingSlot getSlot() { return slot; }
    public Vehicle getVehicle() { return vehicle; }
    public String getGateId() { return gateId; }
    public String getId() { return id; }
}
