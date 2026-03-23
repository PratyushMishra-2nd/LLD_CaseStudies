public class BallPen extends Pen {
    public BallPen(Refill refill, PenMechanism mechanism) {
        super(refill, mechanism);
    }

    @Override
    protected int getConsumptionRate() {
        return 1; // Ball pen consumes 1 unit of ink per character
    }
}
