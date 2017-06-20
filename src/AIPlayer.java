import java.awt.*;


public class AIPlayer extends Player{
	
	private String difficulty;
	private Player opponent;
	private Color[][] board = boardModel.getBoard();
	
	public AIPlayer(String name, Color color, BoardModel boardModel, Player opponent) {
		super(name, color, boardModel);
		this.opponent = opponent;
	}
	
	public Move makeMove() {
		return new Move(1,1, this);
	}
	
	public boolean four(int row, int column) {
		Color color = board[row][column];
		if (board[row][column+1] == color && board[row][column+2] == color && board[row][column+3] == color) 
			return true; //checks colors to the right
		
		if (board[row+1][column] == color && board[row+2][column] == color && board[row+3][column] == color) 
			return true; //checks colors to the bottom
		
		if (board[row+1][column+1] == color && board[row+2][column+2] == color && board[row+3][column+3] == color) 
			return true; //checks bottom right diagonal
		
		if (board[row+1][column-1] == color && board[row+2][column-2] == color && board[row+3][column-3] == color) 
			return true; //checks bottom left diagonal
		
		return false;
	}
	
	private boolean three() {
		Color color = opponent.getColor();
		boolean threeDone = false;
		for (int row = 0; row < board.length; row ++) {
			for (int column = 0; column < board[row].length; column++) {
				if (board[row][column+1] == color && board[row][column+2] == color) 
					threeDone = true; //checks colors to the right
				
				if (board[row+1][column] == color && board[row+2][column] == color) 
					threeDone = true; //checks colors to the bottom
				
				if (board[row+1][column+1] == color && board[row+2][column+2] == color) 
					threeDone = true; //checks bottom right diagonal
				
				if (board[row+1][column-1] == color && board[row+2][column-2] == color) 
					threeDone = true; //checks bottom left diagonal
			}
		}
		
		
		return threeDone;
	}
	
	
	
	private boolean two(int row, int column){
		Color color = opponent.getColor();
		boolean twoDone = false;
		if (board[row][column+1] == color) 
			twoDone = true; //checks colors to the right
		
		if (board[row+1][column] == color) 
			twoDone = true; //checks colors to the bottom
		
		if (board[row+1][column+1] == color) 
			twoDone = true; //checks bottom right diagonal
		
		if (board[row+1][column-1] == color) 
			twoDone = true; //checks bottom left diagonal
		
		return twoDone;
	}
	
	
	private Move predictPlayer() {
		return new Move(1,1, opponent);
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
	
	private void asses(Player player) {		
		Color color = player.getColor();
		for(int row = 0; row < board.length; row ++) {
			for(int column = 0; column < board[row].length; column ++) {

			}
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
