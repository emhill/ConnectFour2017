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
	
private Circle board;
private Rectangle boardBase;
private Circle[][] circles;
private BoardModel bm;


public BoardView(BoardModel string) {
	circles = new Circle[7][6];
	int x=0;		
	for(int i =100; x < circles.length; i+=100, x++){
		int y=0;
		for (int t = 135; y < circles[x].length; t+=100, y++){
			circles[x][y] = new Circle(i, t, 40, Color.yellow.darker());
			System.out.println(x + y + i + t);
			}
		}
	
	boardBase = new Rectangle(50,90,700, 600, Color.yellow);
	this.setPreferredSize(new Dimension(800,800));
	board = new Circle(200,170,20, Color.red);
	this.addMouseListener(new MouseAdapter(){
//		public void mouseMoved(MouseEvent e){
//			board.setColor(Color.blue);
//			repaint();
//		}
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = 5;
			int j = (x/100);
//			circles[j][y].setColor(Color.red);
//			repaint();
//			Game_Control gc= new Game_Control();
			Player p = new Player("test", Color.blue, string);
			
			Move move = new Move(j,p);
			Color color = Color.RED;
			//Color[][] b = move.getBoard();
			for (int i =0; i<6; i ++){
				for (int t =0; t<6; t ++){
					//if (b [i] [t] == color)
						circles[i][t].setColor(Color.red);				
					
					
				}
				repaint();
			}
			
			  }
	});
}

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
		

public void displayEndGame(){
	Component windowFrame = null;
	int answer = JOptionPane.showConfirmDialog(windowFrame,"Would you like to play again?","Game Over",
			JOptionPane.YES_NO_OPTION);

	if(answer==JOptionPane.YES_OPTION)
		reset();
	else
		((Window) windowFrame).dispose();
}
int j;
public int getNextMove(){
	this.addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			j = (x/100);
		}
	});
	return j;
}

public void paintComponent(Graphics page){
	 boardBase.paint(page);
	// board.paint(page);
	 for(int i =0; i < circles.length; i++){
			for (int t = 0; t < circles[i].length; t++){
				if (circles[i][t] != null)
				circles[i][t].paint(page);
				}}
}
public static void main(String[] args) {
	JFrame frame = new JFrame ();
	BoardModel b = new BoardModel();
	BoardView phrase = new BoardView(b);
	//		phrase.revealLetter('a');
	
//	phrase.revealFullPhrase();
	JPanel panel = phrase;

	frame.getContentPane().add(panel);
	frame.pack();
	frame.setVisible(true);
}
}
