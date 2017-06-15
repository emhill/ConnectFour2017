import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Parth Patel
public class GameSetupView extends JPanel{
	private String GameName;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("GameSetupView");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new GameSetupView(); 
		panel.setPreferredSize(new Dimension(700,700));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		

	}

	}

