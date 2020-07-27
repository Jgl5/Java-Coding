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

// created per assignment details
public class ManagementCompany {

	private String name;
	private int taxID;
	private double managementFee;
	private  final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property properties[];
	private Plot plot;
	
	// 1-argument constructor
	public Property addProperty(Property propertyName) {
		return propertyName ;
	}
	
	// 4-argument constructor
	public String addProperty(String propertyName, String city, double rent, String ownerName) {
		return propertyName;
	}
	
	// 8-argument constructor
	public String addProperty(String propertyName, String city, double rent, String ownerName,
							int x, int y, int width, int depth) {
		return propertyName;	
	}
	
	public double totalRent() {
		
		double totalRent = 0;
		double rent = 0;
		// control loop
		for(int index = 0; index < properties.length; index++){
			totalRent += rent;
		}
		return totalRent;
	}
	/*
	 * NOTE TO SELF: need to review index loops & arrays
	private maxRentPropertyIndex() {
		return;
	}
	public maxRentProp() {
		return;
	}
	// need to figure out the above before starting on this
	public String toString() {
		return "";
	}
	*/	
}
