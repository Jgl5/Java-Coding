package birthday;
import birthday.Toy;

/* the idea is this will make
 * it easier to handle the name instances
 * when there are multiple children
 * in the birthday order
 * even if the name of the children 
 * happen to be spelled identically
 * 
 * The naming convention
 * for the field names here
 * comes from my frustration
 * in figuring out
 * how to make this all work
 * after spend HOURS on this
 * 
 */

public class ChildName {

	private String stupidname;
	private Toy stupidtoy;
	
	public String getName() 
	{
		return stupidname;
	}
	
	public ChildName(String name, int age, String toyname) {
		
		stupidname = name;
		stupidtoy = new Toy(toyname, age);
	}
	
	public String getMessage()
	{
	return "The gift for " +stupidname + "," + stupidtoy.toString();
	}
	public double getCost()
	{
		return stupidtoy.getCost();
	}
	public double addCard()
	{
		return stupidtoy.CARD;
	}
	public double addBalloon()
	{
		return stupidtoy.BALLOON;
	}
	public Toy getToy() 
	{
	return stupidtoy;
	}
}






