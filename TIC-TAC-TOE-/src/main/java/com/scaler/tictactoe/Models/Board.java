package com.scaler.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {

    private int size;
    private List<List<Cell>> board ;

    public Board(int size){
        this.size = size;

        List<List<Cell>> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            ArrayList<Cell> temp = new ArrayList<>();
            for(int j=0;j<size;j++){
                temp.add(new Cell(i,j));
            }
            list.add(temp);
        }

        this.board= list;
    }

    public void printBoard(){

        for(int i=0;i<this.getSize();i++){
            for(int j=0;j<this.getSize();j++){
                Cell cell = this.board.get(i).get(j);
                if(cell.getCellState().equals(CellState.empty)){
                    System.out.print("| -- |");
                }
                else{
                    System.out.print("| "+this.board.get(i).get(j).getPlayer().getSymbol().getSign()+" |");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
