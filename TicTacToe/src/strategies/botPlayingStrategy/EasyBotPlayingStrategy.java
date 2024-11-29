package strategies.botPlayingStrategy;

import Models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override // Board -> List<List<Cell>>
    public Move makeMove(Board board) {
        for(List<Cell> row :  board.getBoard()) {
            for(Cell cell : row) {
                if(cell.getCellstate().equals(CellState.EMPTY)) {
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
