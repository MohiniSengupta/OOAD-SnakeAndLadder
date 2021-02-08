package com.mohini;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

	private Queue<Player> players = new LinkedList<Player>();
	private Player currentPlayer;
	private Board board;
	private Dice dice;
	
	
	// game constructor should take no of players
	// initialisation in constructor
	
	public void initGame() {
		
		System.out.println("Intiating players ...");

		Player player1 = new Player("P1",0);
		Player player2 = new Player("P2",0);
		players =  new LinkedList<Player>();
		players.add(player1);
		players.add(player2);
		
		System.out.println("Intiating board ...");

		board = new SnakeAndLadderBoardImpl();
		board.initBoard(); // keep inside constructor
		System.out.println("Intiating dice ...");

		dice = new SixfacedDice();
		
		System.out.println("Intiating current player ...");

		currentPlayer = players.poll();
		
		System.out.println("Current player for game start = "+ currentPlayer.getName());

	}
	
	public void play() {
		
		while(true) {
			//dice roll method
			int steps = dice.roll();
			System.out.println("Dice roll outcome = "+ steps); //Logger
			System.out.println("current position = "+ currentPlayer.getPosition());
			//make move method
			int newPosition = board.makeMove(currentPlayer.getPosition(), steps);
			currentPlayer.setPosition(newPosition);
			//check winner method
			if(newPosition == 50) { // use constant
					System.out.println(currentPlayer + "WON!!");
					break;
			}
			
			// extract below to separate method - toggle player.
			System.out.println(" position after move= "+ currentPlayer.getPosition());
			players.offer(currentPlayer);
			currentPlayer = players.poll();
			System.out.println("Current player = " + currentPlayer.getName());

		}
	}

	public Queue<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Queue<Player> players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	
}
