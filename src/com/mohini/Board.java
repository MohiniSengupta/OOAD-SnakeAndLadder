package com.mohini;

public interface Board {

	
	void initBoard();
	
	int makeMove(int currentPos, int steps);
	
	boolean isValidPosition(int currentPos);
	
}
