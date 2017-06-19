import java.awt.Dimension;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Parth Patel
public class GameSetupView extends JPanel{
	private String GameName;
	private JTextField textbox;
	private String title; 
	private Frame frame;
	private Icon icon;
	
	
	String a = (String)JOptionPane.showInputDialog(
	                    frame,
	                    "Insert Name here:\n",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    icon,
	                    null,
	                    "");
	
	Object[] possibilities = {"Easy", "Intermediate", "Hard"};
	String b = (String)JOptionPane.showInputDialog(
	                    frame,
	                    "Please Select Difficulty Level:",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    icon,
	                    possibilities,
	                    "ham");
	
	Object[] colors = {"Red", "Yellow", "Blue", "Green"};
	String c = (String)JOptionPane.showInputDialog(
	                    frame,
	                    "Please Select Difficulty Level:",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    icon,
	                    colors,
	                    "ham");
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new GameSetupView(); 
		panel.setPreferredSize(new Dimension(700,700));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		

	}

}
