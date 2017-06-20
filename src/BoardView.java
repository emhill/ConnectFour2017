import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class BoardView extends JPanel {
	
private Circle board;
private Rectangle boardBase;
private Circle[][] circles;
private BoardModel bm;

public BoardView(BoardModel string) {
	circles = new Circle[7][6];
	int x=0;		
	for(int i =100; x < circles.length; i+=100, x++){
		int y=0;
		for (int t = 135; y < circles[x].length; t+=100, y++){
			circles[x][y] = new Circle(i, t, 40, Color.yellow.darker());
			System.out.println(x + y + i + t);
			}
		}
	
	boardBase = new Rectangle(50,90,700, 600, Color.yellow);
	this.setPreferredSize(new Dimension(800,800));
	board = new Circle(200,170,20, Color.red);
	this.addMouseListener(new MouseAdapter(){
//		public void mouseMoved(MouseEvent e){
//			board.setColor(Color.blue);
//			repaint();
//		}
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = 5;
			int j = (x/100);
			circles[j][y].setColor(Color.red);
			repaint();
//			  int x = (h / bs), y = 0; //nextspace
//			  if (y >= 0) {
//			    b[y][x] = player; //this is not the final solution
//			    player = player==1?2:1; //switch to the other player (1->2  2->1)
			  }
//			}
	});
}
//public void setup() {
	//size(700,600); //draw circles from their top left point
//}
//

private int w = 7, h = 6, bs = 100;
//int[][] b = new int[h][w];
//public int getWinner() {  //loops through rows, columns, diagonals, etc
//  for (int y=0;y<h;y++)for(int x=0;x<w;x++)
//    if(p(y,x)!=0&&p(y,x)==p(y,x+1)&&p(y,x)==p(y,x+2)&&p(y,x)==p(y,x+3)) return p(y,x);
//  for (int y=0;y<h;y++)for(int x=0;x<w;x++)
//    if(p(y,x)!=0&&p(y,x)==p(y+1,x)&&p(y,x)==p(y+2,x)&&p(y,x)==p(y+3,x)) return p(y,x);
//  for (int y=0;y<h;y++)for(int x=0;x<w;x++)for(int d=-1;d<=1;d+=2)
//    if(p(y,x)!=0&&p(y,x)==p(y+1*d,x+1)&&p(y,x)==p(y+2*d,x+2)&&p(y,x)==p(y+3*d,x+3)) return p(y,x);
//  for (int y=0;y<h;y++)for(int x=0;x<w;x++)if(p(y,x)==0) return 0;
//  return -1; //tie
//}
//public int nextSpace(int x) { //finds the next space (from the bottom)
//  for (int y = h-1;y >= 0;y--) if (b[y][x]==0) return y;
//  return -1;
//}

//public void draw() {
  //if (getWinner()==0) {
    //for (int j=0;j<h;j++) for (int i=0;i<w;i++) {
      //fill(255);
 //     rect(i*bs, j*bs, bs, bs);
//      if (b[j][i]>0) {
//        fill(b[j][i]==1?255:0, b[j][i]==2?255:0, 0);
//        ellipse(i*bs, j*bs, bs, bs);
//      }
//    }
//  }
  //restart game
 // else {
//	  boardBase(0);fill(255);text("Player "+getWinner()+" wins. space restarts",WIDTH/2,HEIGHT/2);
//	  if(keyPressed && key == ' ') {
//	  }
//  }

public void reset(){
	
}

public void displayEndGame(){
	Component windowFrame = null;
	int answer = JOptionPane.showConfirmDialog(windowFrame,"Would you like to play again?","Game Over",
			JOptionPane.YES_NO_OPTION);

	if(answer==JOptionPane.YES_OPTION)
		reset();
	else
		((Window) windowFrame).dispose();
}

public void Move(){
	
}

public void paintComponent(Graphics page){
	 boardBase.paint(page);
	// board.paint(page);
	 for(int i =0; i < circles.length; i++){
			for (int t = 0; t < circles[i].length; t++){
				if (circles[i][t] != null)
				circles[i][t].paint(page);
				}}
}
public static void main(String[] args) {
	JFrame frame = new JFrame ();
	BoardView phrase = new BoardView(null);
	//		phrase.revealLetter('a');
	
//	phrase.revealFullPhrase();
	JPanel panel = phrase;

	frame.getContentPane().add(panel);
	frame.pack();
	frame.setVisible(true);
}
}
