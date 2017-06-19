
public class AIPlayer extends Player{
	
	private String difficulty;
	private Player player;
	
	public Move makeMove() {
		return new Move(1,1, player);
	}
	
	public Move predictPlayer() {
		return new Move(1,1, player);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
