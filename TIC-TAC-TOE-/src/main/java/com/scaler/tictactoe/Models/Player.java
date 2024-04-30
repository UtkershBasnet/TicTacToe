package com.scaler.tictactoe.Models;

import com.scaler.tictactoe.Exceptions.InvalidMoveException;
import com.scaler.tictactoe.Strategies.CheckValidity;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {

    private String name;
    private Symbol symbol;

    private PlayerState playerState;
    private CheckValidity checkValidity;

    public Player(String name, Symbol symbol, PlayerState playerState) {
        this.name = name;
        this.symbol = symbol;
        this.playerState = playerState;
        this.checkValidity = new CheckValidity();
    }

    Scanner sc = new Scanner(System.in);

    public Move makeMove(Game game) throws InvalidMoveException {

        System.out.println("Enter the row in which you want to make your move");
        int r = sc.nextInt();
        System.out.println("Enter the col in which you want to make your move");
        int c = sc.nextInt();

        if(!checkValidity.isMoveValid(r-1,c-1,game)){
            throw new InvalidMoveException("Dimensions of cell you entered is not accessible");
        }

        return new Move(new Cell(r-1,c-1));
    }
}
