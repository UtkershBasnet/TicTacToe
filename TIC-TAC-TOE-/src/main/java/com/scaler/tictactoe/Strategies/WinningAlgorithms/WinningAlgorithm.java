package com.scaler.tictactoe.Strategies.WinningAlgorithms;

import com.scaler.tictactoe.Models.Game;
import com.scaler.tictactoe.Models.Move;

public interface WinningAlgorithm {

    boolean checkWinner(Game game , Move move);
}
