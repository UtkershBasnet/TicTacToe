package com.scaler.tictactoe.Models;

import com.scaler.tictactoe.Exceptions.InvalidMoveException;
import com.scaler.tictactoe.Strategies.GameDrawAlgorithm.GameDrawCheck;
import com.scaler.tictactoe.Strategies.GameDrawAlgorithm.GameDrawCheck1;
import com.scaler.tictactoe.Strategies.WinningAlgorithms.WinningAlgorithm;
import com.scaler.tictactoe.Strategies.WinningAlgorithms.WinningAlgorithm1;
import com.scaler.tictactoe.Strategies.WinningAlgorithms.WinningAlgorithm2;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState ;
    private Player winner;
    private int nextPlayerIndex ;
    private WinningAlgorithm winningAlgorithm;
    private GameDrawCheck gameDrawCheckAlgorithm;

    public Game(int size , List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.in_Progress;
        this.winner=null;
        this.nextPlayerIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm2();
        this.gameDrawCheckAlgorithm = new GameDrawCheck1();
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("It is " + currentPlayer.getName() + "'s move.");

        //Move that currentPlayer wants to make
        Move move = currentPlayer.makeMove(this);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.filled);

        Move finalMove = new Move(cellToChange);
        moves.add(finalMove);
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        //Check if the current move is the winning move or not.
        if (winningAlgorithm.checkWinner(this, finalMove)) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }

        //Check if game has drawn
        if(gameDrawCheckAlgorithm.checkIsGameDraw(board)){
            gameState = GameState.DRAW;
        }
    }
}
