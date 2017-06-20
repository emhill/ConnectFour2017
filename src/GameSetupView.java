import java.awt.Dimension;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;


//Parth Patel
public class GameSetupView extends JPanel{
	private static Frame frame;
	private static Icon icon;
	private String Name;
	private String Difficulty;
	private Color Color;
	
public GameSetupView(){
		
	 Name = (String)JOptionPane.showInputDialog(
                frame,
                "Insert Name here:\n",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                "");

		Object[] possibilities = {"Easy", "Intermediate", "Hard"};
		Difficulty = (String)JOptionPane.showInputDialog(
                frame,
                "Please Select Difficulty Level:",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                possibilities,
                "");
		
		Object[] colors = {"Red", "Yellow", "Blue", "Green"};
		Color = (Color)JOptionPane.showInputDialog(
                frame,
                "Please Select A Color:",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                colors,
                "");
}
//	 Name = (String)JOptionPane.showInputDialog(
//                frame,
//                "Insert Name here:\n",
//                "Connect Four",
//                JOptionPane.PLAIN_MESSAGE,
//                icon,
//                null,
//                "");
//
//		Object[] possibilities = {"Easy", "Intermediate", "Hard"};
//		Difficulty = (String)JOptionPane.showInputDialog(
//                frame,
//                "Please Select Difficulty Level:",
//                "Connect Four",
//                JOptionPane.PLAIN_MESSAGE,
//                icon,
//                possibilities,
//                "");
//		
//		Object[] colors = {"Red", "Yellow", "Blue", "Green"};
//		color = (String)JOptionPane.showInputDialog(
//                frame,
//                "Please Select A Color:",
//                "Connect Four",
//                JOptionPane.PLAIN_MESSAGE,
//                icon,
//                colors,
//                "");
		
		
//		Text name = new Text(Name);
//		name.setPreferredSize(new Dimension(650, 50));
//		this.add(name);
//		
//		
//		Text difficulty = new Text(Difficulty);
//		difficulty.setPreferredSize(new Dimension(650, 50));
//		this.add(difficulty);
//		
//		
//		Text color = new Text(Color);
//		color.setPreferredSize(new Dimension(650, 50));
//		this.add(color);
//		


public String getName() {
	return Name;
}

public String getDifficulty() {
	return Difficulty;
}

public Color getColor() {
	return Color;
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