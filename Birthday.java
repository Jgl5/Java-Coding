package birthday;
//access to dialog box functionality
import javax.swing.JOptionPane;
// access currency functionality
import java.text.DecimalFormat;
//access random object class
import java.util.Random;
//
/* 
 * This program asks the user for a name, age, and toy to
 * prepare a birthday gift order for the child/children entered
 * I use a while loop for when the user wants to place an order
 * for more than one child
 */
//
// assignment details state that the driver class must be named "Birthday"
public class Birthday
{
	public static void main(String[] args) 
	{
		String name;			// to hold user input for childName
		String type;			// to holds user input for toyChoice
		String query;			// to hold user input for warning
		int age; 				// to hold user input for childAge
		int orderNumber; 		// to hold a random number
		int anotherToy = 0;		// to use in loop when user has another toy
		double totalCost = 0;	// to track total costs
		DecimalFormat dollar = new DecimalFormat("#,##0.00");	// to format cost
		
		// assignment instructions state the title is to be printed to console
		System.out.println("Toy Order:"); 
		// assignment instructions state greetings to be shown with a dialog box
		JOptionPane.showMessageDialog(null,"Welcome to the Toy Company"
										+ " to choose gifts for young children");
/*
* 
*  this loop enables the program to
*  keep going when the user says
*  they want another toy
*  
*/
		boolean keepGoing = true;
		while (keepGoing) 
		{
			anotherToy++;
		
		// get and store a child's name
		String childName= JOptionPane.showInputDialog("Enter the name of "
														+ "the child ");
		// get the child's age
		String childAge = JOptionPane.showInputDialog("How old is "
														+ "the child?"); 
		// toy type selected
		String toyType = JOptionPane.showInputDialog("Choose a toy: a "
														+ "plushie, blocks, "
														+ "or a book"); 
		// validate age appropriateness here
		
		// passing dialog box input into parameters for child instance
		age = Integer.parseInt(childAge);
		name = childName;
		type = toyType;
		
		// Creates ChildName object
		ChildName child = new ChildName(name, age, type);
		
		// allows me to operate on the toy class
		Toy toy = child.getToy();
													
/* the following is for debugging my boolean:
* 
*		System.out.println(toy.ageOK());
*		
*/		
		// test if toy type is age appropriate
		// if not, asks the user if they wish to cancel the order
				if (toy.ageOK() == false) 
				{ 
					query = JOptionPane.showInputDialog ("That toy is not age appropiate, " 
							+ "do you want to cancel your order?");
					if (query.equalsIgnoreCase("yes") == true) 
					{
						// cancels the entire order process by terminating the loop
						break;
					}
				}
		// asking if they want a card
		String cardPrompt = JOptionPane.showInputDialog("Do you want a card with "
															+ "the gift? "
															+ "Type Yes or No");
		// asking if they want a balloon
		String balloonPrompt = JOptionPane.showInputDialog("Do you want a ballon? "
															+ "Type Yes or No");
		// asking if they want another toy
		String anotherToyPrompt = JOptionPane.showInputDialog("Do you want another "
															+ "toy? "
															+ "Type Yes or No");

		// this ends the while loop
		if (anotherToyPrompt.equalsIgnoreCase("yes") == false )
		{
		keepGoing = false;
		}
		
		// adds cost of card to total
		if (cardPrompt.equalsIgnoreCase("yes") == true)
		{
			totalCost += child.addCard();
		}	
		// adds cost of balloon to total
		if (balloonPrompt.equalsIgnoreCase("yes") == true)
		{
			totalCost += child.addBalloon();
		}
		// assigns total cost
		totalCost += child.getCost();

		// creates the output desired
		System.out.println(child.getMessage());
		}
		// track of the total order cost
		System.out.println("The total cost of your order is $" 
							+dollar.format(totalCost));
		// creates a Random object to generate a random order number
		Random rand = new Random();
		// assigns a positive random number to the order number
		orderNumber = rand.nextInt(Integer.MAX_VALUE);
		
		// prints order number
		System.out.println("Your order number is: \n" +orderNumber); 
		/* need to debug this printf statement
		 * to get a five digit random number
		 * as it gives me an error when I format
		 * I try to format it
		*System.out.printf("%.5f", orderNumber); 
		*/
		System.out.print("Programmer is: Jesus Lopez"); 
	}
}
