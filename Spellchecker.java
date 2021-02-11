// demonstration program to show basic file I/O techniques
// NOTE: program does not prevent overwriting file that already exist with the same name
// CS II, Hood College
// By Jesus Lopez

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class SpellChecker
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter a name for the dictionary file:\t");
		String fileName = input.nextLine();
		
		String textFileExtension = ".txt";
		if (!(fileName.contains(textFileExtension))) 
		{
			fileName = fileName + textFileExtension;
		}
		
		buildFile(fileName);
		ArrayList<String> testDictionary = readinFileContents(fileName);
		
		boolean searchNeeded = true;
		do
		{
			System.out.print("\nEnter 'stop' to exit the program,"
							  + " " + "or enter a search term:\t");
			String searchTerm = input.nextLine().toLowerCase();
			
			if (testDictionary.contains(searchTerm)) 
			{
				int wordPosition = findWordIndex(searchTerm, testDictionary);
				System.out.print("The word" + " " + "'" + searchTerm + "'" + " ");
				System.out.printf("was found at position: %d", wordPosition);
				
			} else if (searchTerm.equals("stop")) {
				
				searchNeeded = false;
				System.out.println("Bye!");
			} else{
				System.out.println("Sorry, that word is not in the dictionary");
			}
		} while (searchNeeded);
	}
	/* PROGRAM END */
	///////////////////////////////////////////////////////////////////////////////
	public static void buildFile(String dictionaryName)
	{
		String[] initialWords = {"apple","bear","cat",
								 "dog","egg","file", 
								 "google","hello",
								 "iphone","jeep"};
		try 
		{
		  PrintWriter writer = new PrintWriter(dictionaryName);
		  for (int term = 0; term < initialWords.length; term++)
		  {
			writer.printf("%s\n", initialWords[term]);
		  }
		  writer.close();

		} catch (FileNotFoundException failedLookup) {
			System.out.println("Failed to make the text file.");
		}
		
	}
	
	public static ArrayList<String> readinFileContents(String fileName)
	{
		ArrayList<String> contents = new ArrayList<>();
		try
		{
			File dictionary = new File(fileName);
			Scanner reader = new Scanner(dictionary);
			
			while (reader.hasNextLine())
			{
				contents.add(reader.nextLine());
			}
			
		} catch (FileNotFoundException failedLookup){
			System.out.println("Failed to find the dictionary file.");
		}
		return contents;
	}
	
	public static int findWordIndex(String searchTarget, ArrayList<String> dictionary)
	{
		int wordPosition = 0;
		return wordPosition = dictionary.indexOf(searchTarget);
	}				
}