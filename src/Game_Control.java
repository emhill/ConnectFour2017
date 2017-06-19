import javax.swing.BoxLayout;
import javax.swing.JFrame;

//Hassan Saeed 
public class Game_Control extends JFrame {
	//Fields
		private BoardView boardView;
		private BoardModel board;
		private Player Player1;
		private Player Player2;
		private Text text1;
		
		
		public Game_Control (){
			super("Hangman Game");
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			text1 = new Text ("Hassan"); 
			super.getContentPane().setLayout(
					new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

			
			super.getContentPane().add(text1);
			super.pack();
			super.setVisible(true);
			

			
		}
		
		
		
		
		
		
		
		public void StartGame () {
			

		}
		public void EndGame (){

	}
		public void takeTurn (){
			
		}
		
		public void reset (){
			
		}
		
		public void setupBoard () {
			
		}
		
		
	public static void main(String[] args) {
		new Game_Control ();
		// TODO Auto-generated method stub

	}

}
