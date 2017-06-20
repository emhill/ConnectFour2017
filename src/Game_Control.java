import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Hassan Saeed 
public class Game_Control extends JFrame {
	//Fields
		private BoardView boardView;
		private BoardModel board;
		private Player Player1;
		private Player Player2;
		private Text text1;
		private GameSetupView panel; 
		//private int nextX = -1;
		
		public Game_Control (){ 
			super("Connect Four");
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			text1 = new Text ("Hassan"); 
			super.getContentPane().setLayout(
					new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
			panel = new GameSetupView();
			board = new BoardModel (); 
			boardView= new BoardView(board);

			//boardView.setFocusable(true);
			super.getContentPane().add(boardView);
			super.getContentPane().add(panel);
			super.pack();
			super.setVisible(true);
			this.StartGame(); 
		
			// Assume human player goes first
			this.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					int x = e.getX();
					//System.out.println(x);
					int nextX = (x/100);
					takeTurn(nextX);
				}
			});

			
		}

		public void StartGame () {
			//System.out.print(panel.getDifficulty());
			this.Player1= new Player(panel.getName(), panel.getColor(), board);
			//this.Player2 = new AIPlayer("KK", Color.black, board, Player1);
			this.Player2 = new Player("Test AI", Color.BLACK, board);
			//this.takeTurn();
			
			
			
		}
			
		public void EndGame (){
		}
		
		private boolean p1Turn = true;
		public void takeTurn (int nextX){
			// TODO Change to if !board.isOver()
			//for (int i= 0; !board.isOver(); i++) {
			if (!board.isOver()) {
				if (p1Turn){
					Move move = new Move(nextX, Player1);
					Player1.makeMove(move);
				}
				else {
					//AI player
					// Player2.makeMove();
					// Human player2 
					Move move = new Move(nextX, Player2);
					Player2.makeMove(move);
				}
				p1Turn = !p1Turn;
				boardView.repaint();
			} else {
				boardView.displayEndGame();
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
