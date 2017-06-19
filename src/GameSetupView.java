import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;


//Parth Patel
public class GameSetupView extends JPanel{
	private String GameName;
	private JTextField textbox;
	private String title; 
	private static Frame frame;
	private static Icon icon;
	
	
public GameSetupView(){
		
		String a = (String)JOptionPane.showInputDialog(
                frame,
                "Insert Name here:\n",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                "");

		Object[] possibilities = {"Easy", "Intermediate", "Hard"};
		String b = (String)JOptionPane.showInputDialog(
                frame,
                "Please Select Difficulty Level:",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                possibilities,
                "");
		
		Object[] colors = {"Red", "Yellow", "Blue", "Green"};
		String c = (String)JOptionPane.showInputDialog(
                frame,
                "Please Select A Color:",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                colors,
                "");
	
		Text Name = new Text(a);
		Name.setPreferredSize(new Dimension(650, 50));
		this.add(Name);
		
		
		Text Difficulty = new Text(b);
		Difficulty.setPreferredSize(new Dimension(650, 50));
		this.add(Difficulty);
		
		
		Text Color = new Text(c);
		Color.setPreferredSize(new Dimension(650, 50));
		this.add(Color);
		
	}

public static void main(String[] args){
	//GameSetupView ConnectFour = new GameSetupView();
	JFrame frame = new JFrame("Connect Four");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new GameSetupView(); 
	panel.setPreferredSize(new Dimension(700,700));
	frame.getContentPane().add(panel);

	frame.getContentPane().setLayout(
			new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	
	
	frame.pack();
	frame.setVisible(true);
}
}