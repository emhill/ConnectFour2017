/**
 * @author kmbugua
 */

import java.awt.*;

public class Player {
	protected String name;
	protected Color color;
	protected BoardModel board;
	
	public Player(String name, Color color, BoardModel boardModel) {
		this.name = name;
		this.color = color;
		this.board = boardModel;
	}
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	public BoardModel getBoardModel() {
		return this.board;
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
