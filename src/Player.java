/**
 /* @author Kibugi Kamau Mbugua
  * This class creates a player that can make moves on the board
  */
 

import java.awt.*;

public class Player {
	protected String name;
	protected Color color;
	protected BoardModel boardModel;
	
	public Player(String name, Color color, BoardModel boardModel) {
		this.name = name;
		this.color = color;
		this.boardModel = boardModel;
		
	}
	
	public void makeMove(Move move) {
		boardModel.updateBoard(move);
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
	

}
