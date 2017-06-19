import java.awt.*;

public class BoardModel {

	private Color[][] board;
	
	public BoardModel() {
		board = new Color[6][7];
	}
	
	public void resetBoard(){
		board = new Color[6][7];
	}
	public Color[][] currBoard(){
		return board;
	}
	
	public boolean isPossibe(Move move){
		if (move == null) {
			return true;
		}
		return false;
	}
	public void updateBoard(Move move){
		
		board[move.getRow()][move.getColumn()] = move.getPlayer().getpColor();
	}
	public String isOver(){
		return null;
	}
}
