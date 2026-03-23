import java.util.Random;

public class LadderGenStrategy implements IGameObjectGenStrategy {
    public void generate(Board board, int count) {
        Random random = new Random();
        int size = board.getSize();
        int added = 0;
        while (added < count) {
            int start = random.nextInt(size - 2) + 2; 
            int maxEnd = size - start;
            if (maxEnd <= 0) continue;
            int end = random.nextInt(maxEnd) + start + 1; 
            if (end > size) end = size;
            if (!board.hasObjectAt(start)) {
                board.addGameObject(new Ladder(start, end));
                added++;
            }
        }
    }
}
