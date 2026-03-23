import java.util.Random;

public class MagicPortalGenStrategy implements IGameObjectGenStrategy {
    public void generate(Board board, int count) {
        Random random = new Random();
        int size = board.getSize();
        int added = 0;
        while (added < count) {
            int start = random.nextInt(size - 2) + 2;
            int end = random.nextInt(size - 2) + 2; 
            if (!board.hasObjectAt(start) && start != end && start != size) {
                board.addGameObject(new MagicPortal(start, end));
                added++;
            }
        }
    }
}
