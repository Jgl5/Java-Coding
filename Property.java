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


/*
 *  the city where the property is located,
 *  the owner's name,
 *  property name,  
 *  the rent amount, 
 * 	the Plot to be occupied by the property
 */
public class Property {

	private String	city;
	private String	owner;
	private String	propertyName;
	private double	rentAmount;
	private Plot	plot;
	
	/* 
	 * constructors below
	 */
	
	// no-argument constructor, with default Plot
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0.0;
		// commenting out plot because it needs debugging
		//plot.plot();
	}
	
	// 4-argument constructor, no Plot provided
	public Property(String cityName, String ownerName, 
					String propertyNameInput, double rentAmountInput){
		city = cityName;
		owner = ownerName;
		propertyName = propertyNameInput;
		rentAmount = rentAmountInput;
	}
	//constructor with plot arguments
	public Property(String cityInput, String ownerInput, 
			String propertyNameInput, double rentAmountInput, 
			int xInput, int yInput, int widthInput, int depthInput){
		
		// declare plot variables
		int x;
		int y;
		int width;
		int depth;
		
		city = cityInput;
		owner = ownerInput;
		propertyName = propertyNameInput;
		rentAmount = rentAmountInput;
		x = xInput;
		y = yInput;
		width = widthInput;
		depth = depthInput;
	}
	
	/*
	 * below are the various setters and getters
	 */
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
		return plot;
	}
	
	public String toString() {
		return "Property Name:" + " " + propertyName + "\n"
				+ "Located in:" + " " + city + "\n"
				+ "Belonging to:" + " " + owner + "\n"
				+ "Rent Amount:" + " " + rentAmount + "\n";
	}
}

