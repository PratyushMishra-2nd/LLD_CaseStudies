import java.util.List;

public class BoardFactory {
    public static Board createBoard(int size, List<IGameObjectGenStrategy> strategies, List<Integer> counts) {
        Board board = new Board(size);
        for (int i = 0; i < strategies.size(); i++) {
            strategies.get(i).generate(board, counts.get(i));
        }
        return board;
    }
}
