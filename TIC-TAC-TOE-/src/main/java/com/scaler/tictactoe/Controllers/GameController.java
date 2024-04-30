package com.scaler.tictactoe.Controllers;

import com.scaler.tictactoe.Exceptions.InvalidMoveException;
import com.scaler.tictactoe.Exceptions.NoHumanException;
import com.scaler.tictactoe.Exceptions.SameSymbolException;
import com.scaler.tictactoe.Models.Game;
import com.scaler.tictactoe.Models.GameState;
import com.scaler.tictactoe.Models.Player;
import com.scaler.tictactoe.Strategies.CheckValidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;


public class GameController {

    private CheckValidity checkValidity;
    public GameController(){
        this.checkValidity= new CheckValidity();
    }

    public Game createGame(int size , List<Player> players) throws SameSymbolException, NoHumanException {

        if(!checkValidity.symbolsValidity(players)){
            throw new SameSymbolException();
        }

        if(!checkValidity.noHumanCheck(players)){
            throw new NoHumanException();
        }

        return new Game(size,players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.getBoard().printBoard();
    }

}
