/**
 * @author Kibugi Kamau Mbugua
 * This class is the base for the board and dictates where pieces go
 */

import java.awt.*;

public class BoardModel {

	private Color[][] board;
	
	public BoardModel() {
		board = new Color[6][7];
	}
	
	//resets the board to be blank
	public void resetBoard(){
		board = new Color[6][7];
	}
	
	//returns the board with filled in positions
	public Color[][] getBoard(){
		return board;
	}
	
	//takes a move and update board positions
	public void updateBoard(Move move){		
		//System.out.println("Updating board" + move);
		if (!isOver())
			board[columnRow(move.getColumn())][move.getColumn()] = move.getPlayer().getColor();
	}
	
	//checks if there are four of the same color in a row
	public boolean four(int row, int column) {
		if (board[row][column] == null)
			return false;
		
		Color color = board[row][column];
		if (column+1 <board[row].length && column+2 <board[row].length && column+3 <board[row].length &&
			board[row][column+1] == color && board[row][column+2] == color && board[row][column+3] == color) 
			return true; //checks colors to the right
		
		if (row+1 < board.length && row+2 < board.length && row+3 < board.length && 
			board[row+1][column] == color && board[row+2][column] == color && board[row+3][column] == color) 
			return true; //checks colors to the bottom
		
		if (column+1 < board[row].length && column+2 < board[row].length && column+3 < board[row].length &&
			row+1 < board.length && row+2 < board.length && row+3 < board.length && 
			board[row+1][column+1] == color && board[row+2][column+2] == color && board[row+3][column+3] == color) 
			return true; //checks bottom right diagonal
		
		if (row+1 < board.length && row+2 < board.length && row+3 < board.length && 
			column-1 < board[row].length && column-2 < board[row].length && column-3 < board[row].length &&
			board[row+1][column-1] == color && board[row+2][column-2] == color && board[row+3][column-3] == color) 
			return true; //checks bottom left diagonal
		
		return false;
	}
	
	//checks if the game is over
	public boolean isOver(){
		for (int row = 0; row < board.length; row++ ) {
			for (int column = 0; column < board[row].length; column++) {	
				if (four(row, column) == true)
					return true;
			}
		}
		return false;
	}
	
	public int columnRow(int column) {
		int row = board.length-1;
		while (row > 0 && board[row][column] != null) {
			row --;
		}
		return row;
	}
	
	//prints the layout of the board to screen
	public void print(){
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				System.out.print(board[row][column]);
				System.out.print(", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		
//		BoardModel b = new BoardModel();
//		Player p1 = new Player("P1", Color.RED, b);
//		AIPlayer p2 = new AIPlayer("AI", Color.BLUE, b, p1, "intermediate");	
//		b.print();
//		System.out.println(b.four(0, 0));
//		System.out.println(b.isOver());
//		
//		Move move = new Move(0, p1);
//		Move move2 = new Move(0, p1);
//		Move move3 = new Move(0, p1);
//		Move move4 = new Move(0, p1);
//		
//		p1.makeMove(move);
//		p1.makeMove(move2);
//		p1.makeMove(move3);
//		p1.makeMove(move4);
//		System.out.println(b.isOver());
//		b.print();
//	
//		p2.makeMove();
//		b.print();
//		System.out.println(b.four(2,0));
	}
	
}
