<<<<<<< HEAD
=======
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
>>>>>>> 60482cf6d04501fae0268e9dc4bcf950e253e476

public class BoardView {
	
<<<<<<< HEAD

	

=======
private Circle board;
private Rectangle boardBase;

public BoardView(String string) {
	this.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			board.setColor(Color.YELLOW);
board = new Circle(200,170,20, Color.yellow);
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
>>>>>>> 60482cf6d04501fae0268e9dc4bcf950e253e476
}
