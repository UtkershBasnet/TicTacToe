package com.scaler.tictactoe.Strategies.WinningAlgorithms;

import com.scaler.tictactoe.Models.Game;
import com.scaler.tictactoe.Models.Move;

import java.util.HashMap;

public class WinningAlgorithm1 implements WinningAlgorithm{

    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();


    public boolean checkWinner(Game game , Move move){

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char x = move.getCell().getPlayer().getSymbol().getSign();

        // Checking in row
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        HashMap<Character,Integer> currRowMap = rowMaps.get(row);
        if(currRowMap.containsKey(x)){
            currRowMap.put(x,currRowMap.get(x)+1);
        }
        else{
            currRowMap.put(x,1);
        }

        if(currRowMap.get(x)==game.getBoard().getSize()) return true;

        // Check in col
        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        HashMap<Character,Integer> currColMap = colMaps.get(col);
        if(currColMap.containsKey(x)){
            currColMap.put(x,currColMap.get(x)+1);
        }
        else{
            currColMap.put(x,1);
        }

        if(currColMap.get(x)==game.getBoard().getSize()) return true;

        //Check Left Diagonal
        if(row==col){
            if(leftDiagonalMap.containsKey(x)){
                leftDiagonalMap.put(x,leftDiagonalMap.get(x)+1);
            }
            else{
                leftDiagonalMap.put(x,1);
            }

            if(leftDiagonalMap.get(x)==game.getBoard().getSize()) return true;
        }

        //Check right Diagonal
        if(row+col==game.getBoard().getSize()-1){
            if(rightDiagonalMap.containsKey(x)){
                rightDiagonalMap.put(x,rightDiagonalMap.get(x)+1);
            }
            else{
                rightDiagonalMap.put(x,1);
            }

            if(rightDiagonalMap.get(x)==game.getBoard().getSize()) return true;
        }

        return false;

    }
}
