public abstract class Pen {
    protected Refill refill;
    protected PenMechanism mechanism;
    protected boolean isReady;

    public Pen(Refill refill, PenMechanism mechanism) {
        this.refill = refill;
        this.mechanism = mechanism;
        this.isReady = false;
    }

    public void start() {
        mechanism.start();
        isReady = true;
    }

    public void write(String text) {
        if (!isReady) {
            System.out.println("Cannot write! Pen is closed (start() not called).");
            return;
        }
        if (refill.getInkLevel() <= 0) {
            System.out.println("Cannot write! Out of ink.");
            return;
        }
        
        int consumption = getConsumptionRate() * text.length();
        refill.consume(consumption);
        System.out.println("Writing in " + refill.getColor() + ": " + text + " [Ink left: " + refill.getInkLevel() + "]");
    }

    public void close() {
        mechanism.close();
        isReady = false;
    }

    public void changeRefill(Refill refill) {
        System.out.println("Changing refill to new " + refill.getColor() + " refill.");
        this.refill = refill;
    }

    protected abstract int getConsumptionRate();
}
