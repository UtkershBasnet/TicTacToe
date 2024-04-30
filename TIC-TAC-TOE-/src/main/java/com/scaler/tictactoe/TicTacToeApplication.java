package com.scaler.tictactoe;

import com.scaler.tictactoe.Controllers.GameController;
import com.scaler.tictactoe.Exceptions.InvalidMoveException;
import com.scaler.tictactoe.Exceptions.SameSymbolException;
import com.scaler.tictactoe.Models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) throws SameSymbolException, InvalidMoveException {

//		SpringApplication.run(TicTacToeApplication.class, args);

		System.out.println("WELCOME TO TIC-TAC-TOE GAME");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of Players in your game");
		int countOfPlayers = sc.nextInt();
		List<Player> players = new ArrayList<>();

		// Creating a List of Players
		for(int i=1;i<=countOfPlayers;i++){
			System.out.println("Enter the name of "+i+" player");
			String name = sc.next();

			System.out.println("Enter the Symbol of "+i+" player (Only 1 character is allowed)");
			char sym = sc.next().charAt(0);

			PlayerState state;
			System.out.println("Enter human if your player is human otherwise bot");
			String x = sc.next();
			if(x.equals("human")) state= PlayerState.Human;
			else state = PlayerState.Bot;

			Player player;

			if(state==PlayerState.Bot){
				System.out.println("enter the level of your Bot : easy , moderate , hard");
				String level = sc.next();
				if(level.equals("easy")) player = new Bot(name , new Symbol(sym) , state , BotLevel.easy);
				else if(level.equals("moderate")) player = new Bot(name , new Symbol(sym) , state , BotLevel.moderate);
				else player = new Bot(name , new Symbol(sym) , state , BotLevel.hard);
			}
			else player = new Player(name,new Symbol(sym),state);
			players.add(player);
		}

		// Taking a input for dimensions of board
		System.out.println("Enter the size of your board");
		int size = sc.nextInt();


		//Creating a GameController Object
		GameController gameController = new GameController();

		//Creating a game
		Game game = new Game(size,players);

		while(gameController.checkGameState(game) == GameState.in_Progress){
			gameController.printBoard(game);
			gameController.makeMove(game);
		}

		if(!game.getGameState().equals(GameState.ENDED)){
			gameController.printBoard(game);
			game.setGameState(GameState.DRAW);
			System.out.println("Game draw");
		}
		else{
			gameController.printBoard(game);
			System.out.println("Player "+ gameController.getWinner(game).getName() + " has won the game");
		}
	}

}
