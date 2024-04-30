package com.scaler.tictactoe.Models;

import com.scaler.tictactoe.Exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{

    private BotLevel botlevel;

    public Bot(String name, Symbol symbol, PlayerState playerState, BotLevel botlevel) {
        super(name, symbol, playerState);
        this.botlevel = botlevel;
    }

    public Move makeMove(Game game){
        int r = -1;
        int c = -1;
        for(int i=0;i<game.getBoard().getSize();i++) {
            for (int j = 0; j < game.getBoard().getSize(); j++) {
                if (game.getBoard().getBoard().get(i).get(j).getCellState().equals(CellState.empty)) {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        return new Move(new Cell(r,c));
    }
}