import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Hassan Saeed 
public class Game_Control extends JFrame {
	//Fields
		private BoardView boardView;
		private BoardModel board;
		private Player Player1;
		private AIPlayer Player2;
		private Text text1;
		private GameSetupView panel; 
		
		
		public Game_Control (){ 
			super("Connect Four");
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			text1 = new Text ("Hassan"); 
			super.getContentPane().setLayout(
					new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
			panel = new GameSetupView();
			board = new BoardModel (); 
			boardView= new BoardView(board);

			
			super.getContentPane().add(boardView);
			super.getContentPane().add(panel);
			super.pack();
			super.setVisible(true);
			this.StartGame(); 
		
			

			
		}

		public void StartGame () {
			System.out.print(panel.getDifficulty());
			this.Player1= new Player(panel.getName(), panel.getBackground(), board);
			this.Player2 = new AIPlayer("KK", Color.black, board, Player1);
			this.takeTurn();
			
			
			
		}
			
		public void EndGame (){
		}
		public void takeTurn (){
			boolean p1Turn = true;
			
			for (int i= 0; !board.isOver(); i++) {
				if (p1Turn){
					Move move = new Move(boardView.getNextMove(), Player1);
					Player1.makeMove(move);
					p1Turn = !p1Turn;
				}
				else {
					Player2.makeMove();
					p1Turn = !p1Turn;
				}
			}

			
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
