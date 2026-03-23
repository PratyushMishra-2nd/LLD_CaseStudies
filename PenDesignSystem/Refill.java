public class Refill {
    private String color;
    private int inkLevel;

    public Refill(String color, int inkLevel) {
        this.color = color;
        this.inkLevel = inkLevel;
    }

    public void consume(int amount) {
        this.inkLevel -= amount;
        if (this.inkLevel < 0) this.inkLevel = 0;
    }

    public int getInkLevel() { return inkLevel; }
    public String getColor() { return color; }
}
