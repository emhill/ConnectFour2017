import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardView extends JPanel {
	
private Circle board;
private Rectangle boardBase;

public BoardView(String string) {
	boardBase = new Rectangle(50,90,500, 500, Color.yellow);
	this.setPreferredSize(new Dimension(700,700));
	board = new Circle(200,170,20, Color.orange);
	this.addMouseListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			board.setColor(Color.blue);
			// use mouse event to get x,y and change circles x,y
			repaint();
		}
	});	
}
	

public void reset(){
	
}

public void displayEndGame(){
	
}

public void Move(){
	
}

public void paintComponent(Graphics page){
	boardBase.paint(page);
	board.paint(page);
	
}

public static void main(String[] args) {
	JFrame frame = new JFrame ();
	BoardView phrase = new BoardView("Random String!");
	//		phrase.revealLetter('a');
	
//	phrase.revealFullPhrase();
	JPanel panel = phrase;

	frame.getContentPane().add(panel);
	frame.pack();
	frame.setVisible(true);
}
}
