//Precious Martine & Sindy Alzate 
//this class is the gui verison of board model 

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class BoardView extends JPanel {
//fields
	private Circle board;
	private Rectangle boardBase;
	private Circle[][] circles;
	private BoardModel bm;
	private boolean went = false;

//creation of dark yellow grid for placement of game tokens
	public BoardView(BoardModel string) {
		bm =string;
		circles = new Circle[bm.getBoard().length][bm.getBoard()[0].length];
		int x=0;	
		for(int i =100; x < circles.length; i+=100, x++){
			int y=0;
			for (int t = 75; y < circles[x].length; t+=100, y++){
				circles[x][y] = new Circle(t, i, 40, Color.yellow.darker());
				//System.out.println(x + y + i + t);
			}
		}
//board base paint 
		boardBase = new Rectangle(30,50,800, 600, Color.yellow);
		this.setPreferredSize(new Dimension(800,800));
		board = new Circle(200,170,20, Color.red);
		
		
		repaint();
	}
	


//reset board
	public void reset(){
		circles = new Circle[7][6];
		int x=0;		
		for(int i =100; x < circles.length; i+=100, x++){
			int y=0;
			for (int t = 135; y < circles[x].length; t+=100, y++){
				circles[x][y] = new Circle(i, t, 40, Color.yellow.darker());
				System.out.println(x + y + i + t);
			}}
		bm.resetBoard();
	}

//end of the game method 
	public void displayEndGame(){
		Component windowFrame = null;
		int answer = JOptionPane.showConfirmDialog(windowFrame,"Would you like to play again?","Game Over",
				JOptionPane.YES_NO_OPTION);

		if(answer==JOptionPane.YES_OPTION)
			reset();
		else
			((Window) windowFrame).dispose();
	}


	public void paintComponent(Graphics page){
		boardBase.paint(page);

		for (int i =0; i<circles.length; i ++){
			for (int t =0; t<circles[i].length; t ++){
				if (bm.getBoard() [i] [t] != null)
					circles[i][t].setColor(bm.getBoard()[i][t]);				

			}}
		//adding game tokens to land at the bottom of board
		for(int i =0; i < circles.length; i++){
			for (int t = 0; t < circles[i].length; t++){
				if (circles[i][t] != null)
					circles[i][t].paint(page);

			}
		}
	}
//main method to test and impliment boardmodel 
	public static void main(String[] args) {
		BoardModel b = new BoardModel();
		Player p1 = new Player("P1", Color.RED, b);
		AIPlayer p2 = new AIPlayer("AI", Color.BLUE, b, p1, "Easy");	
		b.print();

		Move move = new Move(0, p1);
		p1.makeMove(move);
		b.print();

		p2.makeMove();
		b.print();

		JFrame frame = new JFrame ();
		BoardView phrase = new BoardView(b);
		
		JPanel panel = phrase;

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
