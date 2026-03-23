package MultiLevel_Parking_Lot;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Multilevel Parking Lot System ---");

        List<String> gateIds = Arrays.asList("Gate1", "Gate2");
        
        Level level1 = new Level("L1", gateIds);
        
        ParkingSlot s1 = new ParkingSlot("S1", SlotType.SMALL);
        s1.addDistance("Gate1", 10);
        s1.addDistance("Gate2", 50);

        ParkingSlot s2 = new ParkingSlot("S2", SlotType.SMALL);
        s2.addDistance("Gate1", 20);
        s2.addDistance("Gate2", 30);

        level1.addSlot(s1);
        level1.addSlot(s2);

        EntryGate gate1 = new EntryGate("Gate1", new NearestSlotStrategy());
        EntryGate gate2 = new EntryGate("Gate2", new NearestSlotStrategy());

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(level1), Arrays.asList(gate1, gate2));

        Vehicle v1 = new Vehicle("MH-12-1234", SlotType.SMALL);
        Ticket t1 = parkingLot.park(v1, "Gate1");
        
        if (t1 != null) {
            System.out.println("Vehicle " + v1.getNumber() + " parked at " + t1.getSlot().getId());
        }

        Vehicle v2 = new Vehicle("KA-01-9999", SlotType.SMALL);
        Ticket t2 = parkingLot.park(v2, "Gate2");

        if (t2 != null) {
             System.out.println("Vehicle " + v2.getNumber() + " parked at " + t2.getSlot().getId());
        }

        try { Thread.sleep(100); } catch(Exception e) {}

        if (t1 != null) {
            double price = parkingLot.exit(t1);
            System.out.println("Vehicle " + t1.getVehicle().getNumber() + " exited. Paid: $" + price);
        }
    }
}
