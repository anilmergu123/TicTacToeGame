package strategies.winningStrategy;

import Models.*;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    private HashMap<Integer,HashMap<Character,Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character aChar = move.getPlayer().getSymbol().getaChar();
        if(rowMaps.containsKey(row) == false) {
            rowMaps.put(row,new HashMap<>());
        }

        HashMap<Character,Integer> currRowMap = rowMaps.get(row);

        if(currRowMap.containsKey(aChar) == false) {
            currRowMap.put(aChar,0);
        }
        currRowMap.put(aChar,currRowMap.get(aChar)+1);
        return currRowMap.get(aChar).equals(board.getDimension());
    }

    @Override
    public void undo(Move move,int dimension) {
        HashMap<Character,Integer> currRowMap = rowMaps.get(move.getCell().getRow());
        currRowMap.put(move.getPlayer().getSymbol().getaChar(),currRowMap.get(move.getPlayer().getSymbol().getaChar())-1);
    }
}
