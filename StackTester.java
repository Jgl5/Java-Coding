public class StackTester
{
	public static void main(String[] args)
	{
		int testSize = 9;
		MyStack testStack = new MyStack(testSize);
		
		for (int counterValue = 0; counterValue < testSize; counterValue++)
		{
			testStack.push(counterValue);
		}
		
		int rangeEnd = testSize - 1;
		System.out.println("Expected values are: 0 to " + rangeEnd);
		testStack.printStackItems();
		
		if(testStack.isFull())
			System.out.println("Stack is full");
		
		for (int counterValue = 0; counterValue < testSize; counterValue++)
		{
			testStack.pop();
		}
		
		System.out.println("Now testing the successful deletion" 
							+ " " + "of all items in the stack");
		if (testStack.isEmpty())
			System.out.println("Stack is empty");		
	}
}