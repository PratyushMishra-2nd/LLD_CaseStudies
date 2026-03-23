import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------- SNAKE & LADDER (MAGIC PORTAL EDITION) --------");
        // 1. Setup Board (Size 100, 8 Snakes, 8 Ladders, 3 Magic Portals)
        Board board = BoardFactory.createBoard(100, 
            Arrays.asList(new SnakeGenStrategy(), new LadderGenStrategy(), new MagicPortalGenStrategy()), 
            Arrays.asList(8, 8, 3));
            
        // 2. Setup Dice & Strategy
        Dice dice = new Dice(6);
        IMakeMoveStrategy strategy = new BasicMoveStrategy();
        
        // 3. Setup Game
        Game game = new Game(board, dice, strategy);
        game.addPlayer(new Player("Alice"));
        game.addPlayer(new Player("Bob"));
        game.addPlayer(new Player("Charlie"));
        
        // 4. Play
        game.startGame();
    }
}
