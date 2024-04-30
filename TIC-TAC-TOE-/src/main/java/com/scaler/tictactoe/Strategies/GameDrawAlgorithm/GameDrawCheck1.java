package com.scaler.tictactoe.Strategies.GameDrawAlgorithm;

import com.scaler.tictactoe.Models.Board;
import com.scaler.tictactoe.Models.CellState;

public class GameDrawCheck1 implements GameDrawCheck{
    @Override
    public boolean checkIsGameDraw(Board board) {

        int size = board.getSize();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.empty)) return false;
            }
        }
        return true;
    }
}
