package com.mohini;

public class GameController {

	private Game game;

	GameController() {

	}

	public void startGame() {
		// start game based on game name passed, in case extending app for multiple
		// games

		game = new Game();
		System.out.println("Intiating game ...");
		game.initGame();
		System.out.println("Starting game ...");
		game.play();

	}

	public void endGame() {
	}

	public void resetGame() {
	}
}
