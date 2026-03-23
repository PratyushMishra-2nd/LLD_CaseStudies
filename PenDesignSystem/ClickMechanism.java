public class ClickMechanism implements PenMechanism {
    @Override
    public void start() { System.out.println("Clicking pen to start..."); }
    @Override
    public void close() { System.out.println("Clicking pen to close..."); }
}
