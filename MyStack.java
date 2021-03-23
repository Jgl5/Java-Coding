public class MyStack
{
	private int[] stack;
	private int stackMaxSize;
	private int stackTop;
	
	public MyStack(int size)
	{
		stackMaxSize = size;
		stack = new int[stackMaxSize];
		stackTop = -1;
	}
	
	public void push(int number)
	{
			stackTop++;
			stack[stackTop] = number;
	}
	
	public int pop()
	{
		int recordedValue = stack[stackTop];
		stackTop--;
		return recordedValue;
	}
	
	public boolean isEmpty()
	{
		return stackTop == -1;
	}
	
	public boolean isFull()
	{
		return stackTop == stackMaxSize -1;
	}
	
	public void printStackItems()
	{
		for (int itemIndex = 0; itemIndex <= stackTop; itemIndex++)
		{
			System.out.println(stack[itemIndex]);
		}
	}
}