// This program utilizes simple input validation techniques, and stylistically declares variables at the point of their use.
// Hood College, CS 202, assignment_one
// By: Jesus Lopez

import java.util.Scanner;
import java.util.InputMismatchException;
 
class ExamScoreAnalyzer
{
	public static void main(String[] args)
	{
		Scanner inputHandler = new Scanner(System.in);
	 
		System.out.println("For any given number of exam scores,"
						   + " "
						   + "this program will calculate and display"    
						   + '\n'
						   + "the overall average exam score, as well"
						   + " " 
						   + "as any other relative averages."	
						   + '\n');
						   
		/* INPUT PHASE  BEGINS HERE*/
		int examQuantity = 0;
		boolean moreInputNeeded = true;
		do
		{ 
			System.out.print("Enter the number of exam scores:" + " ");
			try 
			{
				//examQuantity = inputHandler.nextInt() 					# not used because it results in infinite loop #
				examQuantity = Integer.parseInt(inputHandler.nextLine());	
				System.out.print('\n');								
				
				// non-positive input constitutes bad input for the purpose of this program
				if (examQuantity <= -1) 
				{
					throw new Exception();
					
				} else if (examQuantity == 0)
				{
					System.out.print("The average is zero.");
					moreInputNeeded = false;
				} else {
					//terminating condition for this do-while loop
					moreInputNeeded = false;
				}
				
			} catch (NumberFormatException nonIntegerInput){
				System.out.println("The quantity must be a whole number,"
								   + " " + "please enter an integer."
								   + '\n' + '\n');
								   
			} catch (Exception nonPositiveIntegerInput) {
				System.out.print("A valid response requires"
								   + " " + "a positive integer."
								   + '\n');
			}
		} while (moreInputNeeded);
		
		// creates array to hold exam scores that will be entered
		double[] examScores = new double[examQuantity];
		
		do
		{
			try
			{	
				for (int index = 0; index < examQuantity; index++)
				{
					System.out.print("Enter an exam score:" + " ");
					examScores[index] = Double.parseDouble(inputHandler.nextLine());
					
					if (examScores[index] <= -1){ throw new Exception(); }
					
					moreInputNeeded = (index == examQuantity - 1) ? false : true;
				} 
			} catch(InputMismatchException nonNumericInput) {
				
					// non-numeric character input constitutes bad input for this program
					System.out.println("Please, only enter numbers.");
			} catch (Exception negativeExamScore){
				System.out.print("A valid exam score requires"
								   + " "  + "a positive number."
								   + '\n' + "You will have to start"
								   + " "  + "entering scores from the beginning."
								   + '\n');
			}
		} while (moreInputNeeded);
		
		/* CALCUATE & OUTPUT PHASE */
		if (examQuantity == 1) {
			
			System.out.printf("\nThe average score is" + " " +"%.2f", examScores[0]);
		}
		
		if (examQuantity > 1)
		{
			double scoresSum = 0.0;
			for (double score : examScores)
			{
				scoresSum += score;
			}
			
			double averageScore = scoresSum / examQuantity;
			System.out.printf("\nThe average score is:" + " " + "%.2f\n", averageScore);
			
			for (double score : examScores)
			{	
				double scoreDifference = 0.0;
				if (score < averageScore)
				{
					scoreDifference = averageScore - score;
					System.out.printf("%.2f", score);
					System.out.printf(" " + "is below average by:" + " " + "%.2f\n", scoreDifference);
				} else {
					scoreDifference = score - averageScore;
					System.out.printf("%.2f", score);
					System.out.printf(" " + "is above the average by:" + " " + "%.2f\n", scoreDifference);
				}
			}
		}
	} // exit main
}