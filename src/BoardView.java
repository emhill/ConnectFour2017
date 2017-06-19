import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardView extends JPanel {
	
private Circle board;
private Rectangle circle;


public BoardView(String string) {
	
	board= new Circle (200,170,20, Color.YELLOW);
			
}


public void reset(){
	
}

public void displyEndGame(){
	
}

public void Move(){
	
}
		

public void paintComponent(Graphics page) {
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
