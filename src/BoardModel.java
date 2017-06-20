import java.awt.*;

public class BoardModel {

	private Color[][] board;
	
	public BoardModel() {
		board = new Color[6][7];
	}
	
	public void resetBoard(){
		board = new Color[6][7];
	}
	
	public Color[][] getBoard(){
		return board;
	}
	
	public boolean isPossibe(Move move){
		if (move == null) {
			return true;
		}
		return false;
	}
	
	public void updateBoard(Move move){		
		board[columnRow(move.getColumn())][move.getColumn()] = move.getPlayer().getColor();
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
	
	public boolean isOver(){
		int nullCounter = 0;
		for (int row = 0; row < board.length; row++ ) {
			for (int column = 0; column < board[row].length; column++) {	
				if (board[row][column] == null)
					nullCounter ++;
				if (four(row, column) == true)
					return true;
			}
		}
		if (nullCounter == 0)
			return true;
		return false;
	}
	
	public int columnRow(int column) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][column] != null)
				return row;
		}
		return board.length-1;
	}
	
}
