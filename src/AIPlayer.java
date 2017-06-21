/**
 * @author Kibugi Kamau Mbuaua
 * This class extends the Player class and creates an artificial player that makes
 * moves on its own.
 */

//TODO AI only plays in one spot

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class AIPlayer extends Player{
	
	private String difficulty;
	private Player opponent;
	private Color[][] board = boardModel.getBoard();
	private boolean isFirstMove;
	
	public AIPlayer(String name, Color color, BoardModel boardModel, Player opponent, String difficulty) {
		super(name, color, boardModel);
		this.opponent = opponent;
		this.isFirstMove = false;
		this.difficulty = difficulty;
	}
	
	//checks if a position can be played if the column is selected
	private boolean canPlay(int row, int column) {
		if(onBoard(row+1,column) && board[row+1][column] != null && onBoard(row, column))
			return true;
		return false;
	}
	
	// checks if a position is on the board
	private boolean onBoard(int row, int column) {
		if (row < board.length && row >0 && column < board[row].length && column > 0 )
			return true;
		return false;
	}
	
	//checks if there are num of one color in a block of four to the right of a position
	private int assesRight(int row, int column, int num, Color color) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (!onBoard(row,column+i))	
				return -1;
				if (board[row][column+i] == color)
					count ++;
		}
		if (count != num) {
			return -1;
		}
		
		for (int i = 0; i < 4; i ++) {
			if(board[row][column+i] == null){
				if (canPlay(row, column+i))
					return column+i;
			}
		}
		return -1;
	}
	
	//checks if there are num of one color in a block of four to the bottom of a position
	private int assesDown(int row, int column, int num, Color color) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (!onBoard(row+i,column))	
				return -1;
				if (board[row+i][column] == color)
					count ++;
		}
		if (count != num) {
			return -1;
		}
		
		for (int i = 0; i < 4; i ++) {
			if(board[row+i][column] == null){
				if (canPlay(row+i, column))
					return column;
			}
		}
		return -1;
	}
	
	//checks if there are num of one color in a block of four to the bottom-right of a position
	private int assesBottomRight(int row, int column, int num, Color color) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (!onBoard(row+i,column+i))	
				return -1;
				if (board[row+i][column+i] == color)
					count ++;
		}
		if (count != num) {
			return -1;
		}
		
		for (int i = 0; i < 4; i ++) {
			if(board[row+i][column+i] == null){
				if (canPlay(row+i, column+i))
					return column+i;
			}
		}
		return -1;
	}
	
	//checks if there are num of one color in a block of four to the bottom-left of a position
	private int assesBottomLeft(int row, int column, int num, Color color) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (!onBoard(row+i,column-i))	
				return -1;
				if (board[row+i][column-i] == color)
					count ++;
		}
		if (count != num) {
			return -1;
		}
		
		for (int i = 0; i < 4; i ++) {
			if(board[row+i][column-i] == null){
				if (canPlay(row+i, column-i))
					return column-i;
			}
		}
		return -1;
	}
	
	// this return the move the AI should make
	public Move AIMove() {
		//the first move
		if (!isFirstMove){
			this.isFirstMove = true;
			return new Move(3, this, boardModel);
		}
		
		//setting difficulty
		int diffInt;
		if (difficulty == "easy") {
			int random = ThreadLocalRandom.current().nextInt(0, 6 + 1);
			return new Move(random, this, boardModel);
		}
		else if (difficulty == "intermediate")
			diffInt = 3;
		else 
			diffInt = 2;
	
		//predicting opponents move
		Color color = opponent.getColor();
		for(int row = 0; row < board.length; row ++) {
			for(int column = 0; column < board[row].length; column ++) {
				if (assesRight(row, column, diffInt, color) > 0)
					return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				else if (assesDown(row, column, diffInt, color) > 0)
					return new Move(assesDown(row, column, diffInt, color), this, boardModel);
				else if (assesBottomRight(row, column, diffInt, color) > 0)
					return new Move(assesBottomRight(row, column, diffInt, color), this, boardModel);
				else if (assesBottomLeft(row, column, diffInt, color) > 0)
					return new Move(assesBottomLeft(row, column, diffInt, color), this, boardModel);
				else{
					
					color = this.color;
					if (assesRight(row, column, diffInt, color) > 0)
						return new Move(assesRight(row, column, diffInt, color), this, boardModel);
					else if (assesDown(row, column, diffInt, color) > 0)
						return new Move(assesDown(row, column, diffInt, color), this, boardModel);
					else if (assesBottomRight(row, column, diffInt, color) > 0)
						return new Move(assesBottomRight(row, column, diffInt, color), this, boardModel);
					else if (assesBottomLeft(row, column, diffInt, color) > 0)
						return new Move(assesBottomLeft(row, column, diffInt, color), this, boardModel);
				}
					
			}
		}
		return new Move(5, this);		
	}

	//posts the AI move to the board
	public void makeMove() {
		this.boardModel.updateBoard(this.AIMove());
	}
	

}
