import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

// TODO AIPlayer had index out of bounds
public class AIPlayer extends Player{
	
	private String difficulty;
	private Player opponent;
	private Color[][] board = boardModel.getBoard();
	private boolean isFirstMove;
	
	public AIPlayer(String name, Color color, BoardModel boardModel, Player opponent) {
		super(name, color, boardModel);
		this.opponent = opponent;
		this.isFirstMove = false;
	}
	
	private boolean canPlay(int row, int column) {
		if(board[row+1][column] != null && onBoard(row, column))
			return true;
		return false;
	}
	
	private boolean onBoard(int row, int column) {
		if (row < board.length && column < board[row].length)
			return true;
		return false;
	}
	
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
	

	public Move AIMove() {
		//the first move
		if (!isFirstMove){
			this.isFirstMove = true;
			return new Move(3, this, boardModel);
		}
		
		//setting difficulty
		if (difficulty == "easy") {
			int random = ThreadLocalRandom.current().nextInt(0, 6 + 1);
			return new Move(random, this, boardModel);
		}
		int diffInt = 2;
		if (difficulty == "medium")
			diffInt = 3;
		if (difficulty == "hard")
			diffInt = 2;
	
		//predicting opponents move
		Color color = opponent.getColor();
		for(int row = 0; row < board.length; row ++) {
			for(int column = 0; column < board[row].length; column ++) {
				if (assesRight(row, column, diffInt, color) > 0)
					return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				else if (assesDown(row, column, diffInt, color) > 0)
					return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				else if (assesBottomRight(row, column, diffInt, color) > 0)
					return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				else if (assesBottomLeft(row, column, diffInt, color) > 0)
					return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				else{
					
					color = this.color;
					if (assesRight(row, column, diffInt, color) > 0)
						return new Move(assesRight(row, column, diffInt, color), this, boardModel);
					else if (assesDown(row, column, diffInt, color) > 0)
						return new Move(assesRight(row, column, diffInt, color), this, boardModel);
					else if (assesBottomRight(row, column, diffInt, color) > 0)
						return new Move(assesRight(row, column, diffInt, color), this, boardModel);
					else if (assesBottomLeft(row, column, diffInt, color) > 0)
						return new Move(assesRight(row, column, diffInt, color), this, boardModel);
				}
					
			}
		}
		return new Move(5, this);		
	}

	
	public void makeMove() {
		this.boardModel.updateBoard(this.AIMove());
	}
	
	public static void main(String[] args) {
	}

}
