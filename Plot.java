package buildingBlind;

/*
 * Class: CMSC 203 CRN 4666
 * Program: Assignment #4
 * Instructor: Dr.Grinberg
 * Program challenges passing objects as parameters, using arrays, and constructors
 * Due: July July 26, 2020
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Student: Jesus Lopez
 */

public class Plot {

	private int	x		= 0;
	private	int	y		= 0;
	private int	width	= 0;
	private	int	depth	= 0;
	
	/*
	 * below are the various constructors
	 */
	
	// No-argument constructor
	public void plot() {
	this.x = 0;
	this.y = 0;
	this.width = 1;
	this.depth = 1;
	}
	
	// Parameterized constructor
	public Plot (int x, int y, int width, int depth) {
	
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	// Copy constructor, to create new object using information of the object passed
	public Plot (Plot p) {
			
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	
	/*
	 * below are the various setters and getters
	 */
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// need to build the if/else for booleans
	public boolean overlaps (Plot plot) {
		return true;
	}
	
	public boolean encompasses (Plot plot) {
		return true;
	}
	
	public String toString() {
		return "Upper left:" + "(" + x + "," + y + ")" + ";\n"
				+ "Width:" + "" + width + "Depth:" + "" + depth 
				+ "\n";
	}
}
