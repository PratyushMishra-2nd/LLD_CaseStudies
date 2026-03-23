public class BasicMoveStrategy implements IMakeMoveStrategy {
    public int makeMove(int currentPosition, int diceRoll, int boardSize) {
        int nextPosition = currentPosition + diceRoll;
        if (nextPosition > boardSize) { return currentPosition; }
        return nextPosition;
    }
}
