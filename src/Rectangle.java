import java.awt.Color;
import java.awt.Graphics;
/**
 * this class makes a rectangle 
 * @author Precious
 *
 */

public class Rectangle {

	//creating 5 fields to class
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	//adding default constructor 
	public Rectangle(){
		x=8;
		y=10;
		width = 20;
		height= 40;
		color= Color.GREEN;
		
	}
	
	//adding constructor with 5 parameters
	public Rectangle (int x , int y, int w,int h, Color c){
		this.x=x;
		this.y=y;
	    width=w;
		height=h;
		color=c;
	}
	
	//adding get and set methods 
	
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;

	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;

	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void paint(Graphics page){
		page.setColor(color);
		page.fillRect(x,y,width,height);
	}
	
	
	public static void main(String[] args) {
		Rectangle x =  new Rectangle();
		//System.out.println("Width:" + " " +  width);
	//set width to different value 
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
