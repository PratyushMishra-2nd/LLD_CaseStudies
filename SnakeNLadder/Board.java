import java.util.Map;
import java.util.HashMap;

public class Board {
    private int size;
    private Map<Integer, GameObjectInterface> jumps;
    
    public Board(int size) { this.size = size; this.jumps = new HashMap<>(); }
    public void addGameObject(GameObjectInterface obj) { jumps.put(obj.getStart(), obj); }
    public int getSize() { return size; }
    
    public int resolvePosition(int pos) {
        if (jumps.containsKey(pos)) {
            GameObjectInterface jump = jumps.get(pos);
            System.out.println("  => Encountered " + jump.getName() + " at " + pos + "! Jumping to " + jump.getEnd());
            int newPos = jump.getEnd();
            return newPos;
        }
        return pos;
    }
    
    public boolean hasObjectAt(int pos) { return jumps.containsKey(pos); }
}
