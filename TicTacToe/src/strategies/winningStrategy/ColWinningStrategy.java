package strategies.winningStrategy;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy {

    private HashMap<Integer, HashMap<Character,Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();
        if(colMaps.containsKey(col) == false) {
            colMaps.put(col,new HashMap<>());
        }

        HashMap<Character,Integer> currColMap = colMaps.get(col);

        if(currColMap.containsKey(aChar) == false) {
            currColMap.put(aChar,0);
        }
        currColMap.put(aChar,currColMap.get(aChar)+1);
        return currColMap.get(aChar).equals(board.getDimension());
    }

    @Override
    public void undo(Move move,int dimension) {
        HashMap<Character,Integer> currColMap = colMaps.get(move.getCell().getRow());
        currColMap.put(move.getPlayer().getSymbol().getaChar(),currColMap.get(move.getPlayer().getSymbol().getaChar())-1);
    }


}
