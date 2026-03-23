package MultiLevel_Parking_Lot;

public class PricingStrategyFactory {
    public static PricingStrategy get(SlotType type) {
        switch (type) {
            case SMALL: return new SmallPricing();
            case MEDIUM: return new MediumPricing();
            case LARGE: return new LargePricing();
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}

class SmallPricing implements PricingStrategy {
    public double calculate(Ticket ticket) {
        long hours = (System.currentTimeMillis() - ticket.getEntryTime()) / (1000 * 60 * 60) + 1;
        return hours * 50.0;
    }
}

class MediumPricing implements PricingStrategy {
    public double calculate(Ticket ticket) {
        long hours = (System.currentTimeMillis() - ticket.getEntryTime()) / (1000 * 60 * 60) + 1;
        return hours * 80.0;
    }
}

class LargePricing implements PricingStrategy {
    public double calculate(Ticket ticket) {
        long hours = (System.currentTimeMillis() - ticket.getEntryTime()) / (1000 * 60 * 60) + 1;
        return hours * 120.0;
    }
}
