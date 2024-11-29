package strategies.winningStrategy;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{

    private HashMap<Character,Integer> leftDiagonalMap = new HashMap<>();
    private HashMap<Character,Integer> rightDiagonalMap = new HashMap<>();


    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if(row == col) {
            if(!leftDiagonalMap.containsKey(aChar)) {
                leftDiagonalMap.put(aChar,0);
            }
            leftDiagonalMap.put(aChar,leftDiagonalMap.get(aChar)+1);

            if(leftDiagonalMap.get(aChar).equals(board.getDimension())) {
                return true;
            }
        }
        if (row + col == board.getDimension() - 1) {
            if(!rightDiagonalMap.containsKey(aChar)) {
                rightDiagonalMap.put(aChar,0);
            }
            rightDiagonalMap.put(aChar,rightDiagonalMap.get(aChar)+1);

            if(rightDiagonalMap.get(aChar).equals((board.getDimension()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void undo(Move move,int dimension) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if(row == col) {
            leftDiagonalMap.put(aChar,leftDiagonalMap.get(aChar)-1);
        }
        if (row + col == dimension - 1) {
            rightDiagonalMap.put(aChar,rightDiagonalMap.get(aChar)-1);
        }
    }
}
