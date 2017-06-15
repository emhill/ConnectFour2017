import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardView extends JPanel {
	
private Circle board;
private Rectangle circle;


public BoardView(String string) {
	// TODO Auto-generated constructor stub
}

public void reset(){
	
}

public void displyEndGame(){
	
}

public void Move(){
	
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
