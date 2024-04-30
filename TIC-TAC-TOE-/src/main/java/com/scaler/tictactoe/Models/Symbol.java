package com.scaler.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {

    private char sign;

    public Symbol(char sign) {
        this.sign = sign;
    }
}
