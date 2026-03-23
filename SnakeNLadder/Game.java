import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private Queue<Player> players;
    private Board board;
    private Dice dice;
    private IMakeMoveStrategy moveStrategy;
    private List<Player> winners;
    
    public Game(Board board, Dice dice, IMakeMoveStrategy strategy) {
        this.board = board; this.dice = dice; this.moveStrategy = strategy;
        this.players = new LinkedList<>(); this.winners = new ArrayList<>();
    }
    
    public void addPlayer(Player player) { this.players.offer(player); }
    
    public void startGame() {
        System.out.println("Starting Game...");
        while (players.size() > 1) { playTurn(); }
        if (!players.isEmpty()) { System.out.println("Player " + players.poll().getId() + " lost the game (last remaining)."); }
        System.out.println("Game Over! Winners order: ");
        for (int i=0; i<winners.size(); i++) {
            System.out.println((i+1) + " Place: " + winners.get(i).getId());
        }
    }
    
    private void playTurn() {
        Player currentPlayer = players.poll();
        int roll = dice.roll();
        System.out.print(currentPlayer.getId() + " is at " + currentPlayer.getPosition() + " and rolled " + roll + ".");
        
        int nextPos = moveStrategy.makeMove(currentPlayer.getPosition(), roll, board.getSize());
        
        if (nextPos == currentPlayer.getPosition()) {
            System.out.println(" Over-rolled! Needs exact number to win.");
        } else {
            System.out.println(" Moves to " + nextPos);
            nextPos = board.resolvePosition(nextPos);
            currentPlayer.setPosition(nextPos);
        }
        
        if (currentPlayer.getPosition() == board.getSize()) {
            System.out.println("  🎉 " + currentPlayer.getId() + " has reached the end!");
            winners.add(currentPlayer);
        } else {
            players.offer(currentPlayer);
        }
        // Small delay so humans can read it while running
        try { Thread.sleep(500); } catch (Exception e) {}
    }
}
