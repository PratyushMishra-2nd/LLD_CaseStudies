public class PenFactory {
    public static Pen createPen(PenType type, MechanismType mechanismType, String color) {
        PenMechanism mechanism;
        if (mechanismType == MechanismType.CLICK) {
            mechanism = new ClickMechanism();
        } else {
            mechanism = new CapMechanism();
        }

        Refill refill = new Refill(color, 100);

        if (type == PenType.BALL) {
            return new BallPen(refill, mechanism);
        } else if (type == PenType.GEL) {
            return new GelPen(refill, mechanism);
        }
        throw new IllegalArgumentException("Unknown PenType");
    }
}
