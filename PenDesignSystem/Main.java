public class Main {
    public static void main(String[] args) {
        System.out.println("--- Pen Design System Demo ---");

        System.out.println("\n1. Creating a Blue Ball Pen with Click Mechanism:");
        Pen ballPen = PenFactory.createPen(PenType.BALL, MechanismType.CLICK, "Blue");
        ballPen.write("This should fail."); // Should fail
        ballPen.start();
        ballPen.write("Hello World!");
        ballPen.close();

        System.out.println("\n2. Creating a Red Gel Pen with Cap Mechanism:");
        Pen gelPen = PenFactory.createPen(PenType.GEL, MechanismType.CAP, "Red");
        gelPen.start();
        gelPen.write("Gel pens are smooth.");
        gelPen.close();

        System.out.println("\n3. Refill Replacement Test:");
        ballPen.start();
        ballPen.write("Writing a very long essay to drain the ink... ".repeat(5));
        ballPen.changeRefill(new Refill("Black", 100));
        ballPen.write("Writing with new black refill.");
        ballPen.close();
    }
}
