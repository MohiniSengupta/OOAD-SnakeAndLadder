package com.mohini;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderBoardImpl implements Board{

	// private, final
	List<Snake> snakes = new ArrayList<Snake>();
	
	//private, final
	List<Ladder> ladders = new ArrayList<Ladder>();
	
	// board size can be variable
	
	@Override
	public void initBoard() {
		
		// abstract out snake ladder config into another class
		// config will have private lists of snke  and ladder
		
		
		// 1. init snakes
		Snake s1 = new Snake(20,10);
		Snake s2 = new Snake(30,15);
		Snake s3 = new Snake(42,12);
		Snake s4 = new Snake(25,12);
		Snake s5 = new Snake(40,35);
		snakes.add(s1);
		snakes.add(s2);
		snakes.add(s3);
		snakes.add(s4);
		snakes.add(s5);


		// 2. init ladders
		Ladder l1 = new Ladder(4,27);
		Ladder l2 = new Ladder(2,23);
		Ladder l3 = new Ladder(3,29);
		Ladder l4 = new Ladder(5,45);
		Ladder l5 = new Ladder(6,48);
		Ladder l6 = new Ladder(1,24);

		ladders.add(l1);
		ladders.add(l2);
		ladders.add(l3);
		ladders.add(l4);
		ladders.add(l5);
		ladders.add(l6);

}
	
	
	@Override
	public int makeMove(int currentPos, int steps) { // final //makemoveandreturnposition name
		
		int newPosition = currentPos + steps;
		if(isValidPosition(newPosition)) {
			System.out.println("Valid move!!!!");

			//check snake in place
			for(Snake snake : snakes) { // extract to method , hashmap

				if(snake.getHead() == newPosition) {
					System.out.println("Snake found!!");
					newPosition = snake.getTail();
					break;
				}
			}
			
			// check ladder in place

			for(Ladder ladder : ladders) {// extract to method , hashmap

				if(ladder.getStart() == newPosition) {
					System.out.println("Ladder found!!");
					newPosition = ladder.getEnd();
					break;
				}
			}
			
		}else {
			return currentPos;
		}
		
		return newPosition;
	}

	@Override
	public boolean isValidPosition(int currentPos) {

		if(currentPos < 1 || currentPos > 50) {
			System.out.println("Invalid Move!!");
			return false;
		}
		
		return true;
	}

	

}
