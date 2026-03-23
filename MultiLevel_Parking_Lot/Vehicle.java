package MultiLevel_Parking_Lot;

public class Vehicle {
    private String number;
    private SlotType type;

    public Vehicle(String number, SlotType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() { return number; }
    public SlotType getType() { return type; }
}
