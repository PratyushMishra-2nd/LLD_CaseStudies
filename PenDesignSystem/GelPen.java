public class GelPen extends Pen {
    public GelPen(Refill refill, PenMechanism mechanism) {
        super(refill, mechanism);
    }

    @Override
    protected int getConsumptionRate() {
        return 2; // Gel pen consumes 2 units of ink per character
    }
}
