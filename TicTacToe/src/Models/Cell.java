package Models;

public class Cell {
    int row;
    int col;
    Player player;
    CellState cellstate;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellstate = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public void display() {
        if (player == null) {
            //cell is empty
            System.out.print("| -- |");
        } else {
            System.out.print("| " + player.getSymbol().getaChar() + " |") ;
        }
    }
}
