import java.awt.Color;

public class AIPlayer extends Player{

	private String difficulty;
	private Player player;
	
	public AIPlayer(String name, Color color, BoardModel boardModel) {
		super(name, color, boardModel);
	}
	
	public Move makeMove() {
		return new Move(1,1, player);
	}
	
	public boolean three() {
		return false;
	}
	
	public boolean two(){
		return false;
	}
	
	public boolean canComplete() {
		return false;
	}
	
	
	
	public Move predictPlayer() {
		return new Move(1,1, player);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
