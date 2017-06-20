/**
 * @author kmbugua
 */

import java.awt.*;

public class Player {
	protected String name;
	protected Color color;
	protected BoardModel boardModel;
	protected Color [][] board;
	
	public Player(String name, Color color, BoardModel boardModel) {
		this.name = name;
		this.color = color;
		this.boardModel = boardModel;
		this.board = boardModel.getBoard();
	}
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
