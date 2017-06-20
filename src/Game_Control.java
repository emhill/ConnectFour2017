import java.awt.Color;

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
			super("Connect Four");
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
			boardView.reset();
			board.resetBoard();
				
		}

	public BoardModel getBoard() {
			return board;
		}
		
	public void setBoard(BoardModel board) {
			this.board = board;
		}

	public static void main(String[] args) {
		Game_Control g = new Game_Control();
		
		//Player player = new Player("C4", Color.black.brighter(), g.getBoard());
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
