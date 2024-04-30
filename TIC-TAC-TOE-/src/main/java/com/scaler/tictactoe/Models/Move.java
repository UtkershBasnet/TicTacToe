package com.scaler.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    Cell cell;

    public Move(Cell cell) {
        this.cell = cell;
    }
}
