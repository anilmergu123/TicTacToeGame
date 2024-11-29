package Models;

import java.util.Scanner;

public class Player {
    Symbol symbol;
    String name;
    PlayerType playerType;
    private Scanner sc = new Scanner(System.in);

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Please enter the row number where you want to make a move");
        int row = sc.nextInt();

        System.out.println("Please enter the col number where you want to make a move");
        int col = sc.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
