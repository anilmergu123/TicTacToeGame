package strategies.winningStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
    void undo(Move move,int dimension);
}
