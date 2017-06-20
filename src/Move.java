/*
 * Store board moves
 */
public class Move {
	private int row, column;
	Player player;
	
	public Move(int row, int column, Player player) {
		this.row = row;
		this.column = column;
		this.player = player;
	}
	
	public Move(int column, Player player, BoardModel boardModel) {
		this.column = column;
		this.player = player;
		this.row = boardModel.columnRow(column);
	}

	/**
	 * @return the x
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the y
	 */
	public int getColumn() {
		return column;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	
}
