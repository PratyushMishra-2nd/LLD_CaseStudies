import java.util.Random;

public class SnakeGenStrategy implements IGameObjectGenStrategy {
    public void generate(Board board, int count) {
        Random random = new Random();
        int size = board.getSize();
        int added = 0;
        while (added < count) {
            int start = random.nextInt(size - 2) + 2; 
            int end = random.nextInt(start - 1) + 1; 
            if (!board.hasObjectAt(start)) {
                board.addGameObject(new Snake(start, end));
                added++;
            }
        }
    }
}
