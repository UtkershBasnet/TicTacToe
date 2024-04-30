package com.scaler.tictactoe.Strategies.WinningAlgorithms;

import com.scaler.tictactoe.Models.*;

import java.util.List;

public class WinningAlgorithm2 implements WinningAlgorithm{
    @Override
    public boolean checkWinner(Game game, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char x = move.getCell().getPlayer().getSymbol().getSign();
        int size = game.getBoard().getSize();
        List<List<Cell>> list = game.getBoard().getBoard();

        //Checking in row
        boolean check=true;
        for(int i=0;i<size;i++){
            if(list.get(row).get(i).getCellState().equals(CellState.empty)){
                check=false;
                break;
            }
            if(list.get(row).get(i).getPlayer().getSymbol().getSign()!=x){
                check=false;
                break;
            }
        }
        if(check) return true;

        //checking in col
        check = true;
        for(int i=0;i<size;i++){
            if(list.get(i).get(col).getCellState().equals(CellState.empty)){
                check=false;
                break;
            }
            if(list.get(i).get(col).getPlayer().getSymbol().getSign()!=x){
                check=false;
                break;
            }
        }
        if(check) return true;

        // Checking in left Diagonal
        int count = 0;
        int r=row;
        int c=col;

        while(r>=0 && c<size && c>=0 && r<size){
            if(list.get(r).get(c).getCellState().equals(CellState.empty)){
                break;
            }
            else if(list.get(r).get(c).getPlayer().getSymbol().getSign()==x) count++;
            r++;
            c++;
        }
        r=row-1;
        c=col-1;
        while(r>=0 && c<size && c>=0 && r<size){
            if(list.get(r).get(c).getCellState().equals(CellState.empty)){
                break;
            }
            if(list.get(r).get(c).getPlayer().getSymbol().getSign()==x) count++;
            r--;
            c--;
        }

        if(count==size) return true;

        // Checking in Right Diagonal
        count = 0;
        r=row;
        c=col;

        while(r>=0 && c<size && c>=0 && r<size){
            if(list.get(r).get(c).getCellState().equals(CellState.empty)){
                break;
            }
            if(list.get(r).get(c).getPlayer().getSymbol().getSign()==x) count++;
            r++;
            c--;
        }
        r=row-1;
        c=col-1;
        while(r>=0 && c<size && c>=0 && r<size){
            if(list.get(r).get(c).getCellState().equals(CellState.empty)){
                break;
            }
            if(list.get(r).get(c).getPlayer().getSymbol().getSign()==x) count++;
            r--;
            c++;
        }
        if(count==size) return true;

        // If none of the condition matches
        return false;
    }
}
