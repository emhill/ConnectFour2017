import java.awt.Color;
import java.awt.Graphics;

/**
 * This class creates a circle
 * @author Precious
 *
 */


//creating fields for x, y color and radius
public class Circle {
	
	private int x, y, radius;
	private Color color;
	
	public Circle() {
		this(2, 4, 10, Color.RED);
//		x = 2;
//		y = 4;
//		radius = 10;
//		color = Color.RED;
	}
	
	public Circle(int x, int y, int r, Color c) {
		this.x = x;
		this.y = y;
		radius = r;
		color = c;
	}

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
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
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
	
	public void paint(Graphics page) {
		page.setColor(color);
		page.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + ", color=" + color + "]";
	}

	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle);
		
		circle.setColor(Color.CYAN);
		circle.setRadius(50);
		circle.setX(55);
		circle.setY(60);
		
		System.out.println(circle);
		
		Circle c = new Circle(12, 16, 13, Color.black);
		System.out.println(c);
	}

}
