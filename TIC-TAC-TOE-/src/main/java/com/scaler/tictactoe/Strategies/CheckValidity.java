package com.scaler.tictactoe.Strategies;

import com.scaler.tictactoe.Models.*;

import java.util.HashSet;
import java.util.List;

public class CheckValidity {

    public boolean symbolsValidity(List<Player> players){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<players.size();i++){
            set.add(players.get(i).getSymbol().getSign());
        }

        if(set.size()==players.size()) return true;
        else return false;
    }

    public boolean isMoveValid(int r , int c , Game game){

        // Checking dimensions are valid
        if(r>=game.getBoard().getSize() || c>= game.getBoard().getSize() || r<0 || c<0){
            return false;
        }

        // Checking cell is Empty
        if(game.getBoard().getBoard().get(r).get(c).getCellState()== CellState.filled) return false;

        return true;
    }

    public boolean noHumanCheck(List<Player> players){
        for(int i=0;i<players.size();i++){
            if(players.get(i).getPlayerState().equals(PlayerState.Human)) return true;
        }
        return false;
    }


}
