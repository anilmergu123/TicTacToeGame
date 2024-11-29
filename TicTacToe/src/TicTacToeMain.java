import Models.*;
import controllers.GameController;
import exceptions.InvalidMoveException;
import strategies.winningStrategy.ColWinningStrategy;
import strategies.winningStrategy.DiagonalWinningStrategy;
import strategies.winningStrategy.RowWinningStrategy;
import strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Undo


public class TicTacToeMain {
    public static void main(String args[]) throws InvalidMoveException {

        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
//      int dimension = sc.nextInt();
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();


        players.add(new Player(new Symbol('X'),"Anil", PlayerType.HUMAN));
        players.add(new Bot(new Symbol('O'),"Jyo", PlayerType.BOT,BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());


        Game game = gameController.startGame(dimension, players, winningStrategies);

        while (gameController.gameState(game).equals(GameState.IN_PROGRESS)) {
            //1. Show the board.
            //2. make a move.
            gameController.printBoard(game);
            Player curPlayer = game.getPlayers().get(game.getNextMovePlayerIndex());
            try{
                gameController.makeMove(game);
            }
            catch (InvalidMoveException invalidMoveException) {
                System.out.println(invalidMoveException);
                continue;
            }

            if(curPlayer.getPlayerType().equals(PlayerType.HUMAN) && game.getMoves().size() != 0) {
                game.printBoard();
                System.out.println("Do you want to undo ? y/n");
                String isUndo = sc.next();
                if (isUndo.equalsIgnoreCase("y")) {
                    //make an undo operation
                    gameController.undo(game);
                    if(game.getNextMovePlayerIndex() == 0) {
                        game.setNextMovePlayerIndex(game.getPlayers().size()-1);
                    }
                    else {
                        game.setNextMovePlayerIndex(game.getNextMovePlayerIndex()-1);
                    }
                    continue;
                }
            }
        }

        gameController.printBoard(game);
        if (gameController.gameState(game).equals(GameState.ENDED)) {
            System.out.println(gameController.getWinner(game).getName() + " has won the game. Congratulations!");
        } else {
            System.out.println("GAME DRAW");
        }
    }

}
