//Parth Patel

//Imports
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

//GameSetupView Class
public class GameSetupView extends JPanel{
	
//Fields
	private static Frame frame;
	private static Icon icon;
	private String Name;
	private String Difficulty;
	private Color Color;
	
//GameSetupView Constructor
public GameSetupView(){
		
//Dialog Boxes for User Game Setup
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
		
		String[] colors = {"Red", "Yellow", "Blue", "Green"};
		String color = (String)JOptionPane.showInputDialog(
                frame,
                "Please Select A Color:",
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                colors,
                "");
		
//Conversions from User Choices to actual Colors
		if (color == "Red"){
			Color = Color.RED;
		}
		if (color == "Yellow"){
			Color = Color.YELLOW;
		}
		if (color=="Blue"){
			Color = Color.BLUE;
		}
		if (color == "Grenn"){
			Color = Color.GREEN;
		}
}

//Get Methods for Player Inputs
public String getName() {
	return Name;
}

public String getDifficulty() {
	return Difficulty;
}

public Color getColor() {
	return Color;
}

//Main 
public static void main(String[] args){
	//Creation of Connect Four Game Window
	
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