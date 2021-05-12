
// CS II, Hood College
// By Jesus Lopez

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

class SpellChecker
{
	public static void main(String[] args)
	{

		ArrayList<String> dictionary = makeDictionaryFromFile("default.txt");
		String[] parsedLines = parseDocumentIntoLines("test-document.txt");

		TST tree = new TST();
		
		for(String word: dictionary)										
			tree.loadIntoTree(word);
		
		for (int index = 0; index < parsedLines.length; index++)
		{
			String individualLine = parsedLines[index];
			String[] wordsInLine = individualLine.split("\\s");	

			for(String word: wordsInLine)
			{
				if(word.equals(""))
						continue;	// patch to avoid exception error
				if((tree.contains(word.toLowerCase())) != true)
				{
					int lineNumber = index +1;
					reportUnrecognizedWords(word, lineNumber);	
				}								
			}	}
	}

	/* STATIC METHODS BELOW */
	public static String[] parseDocumentIntoLines(String fileName)
	{

		ArrayList<String> parsedLines = new ArrayList<String>();

		try 
		{
			FileInputStream fstream = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));


			String currentLine;
			while((currentLine = br.readLine()) != null)  
			{  
				String[] tokens = currentLine.split("\\n|\\.|\\?|\\!|\\;|\\:|\\,");
				for(int wordPosition = 0; wordPosition < tokens.length; wordPosition++)
					tokens[wordPosition] = tokens[wordPosition].trim();
				for (String line: tokens)							
					parsedLines.add(line);
			}  
			br.close();  

		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] array = parsedLines.toArray(new String[0]);
		return array;
	}

	/* STATIC METHODS */

	public static void reportUnrecognizedWords(String word, int lineNumber)
	{ 
		String msg = "The word '" + word + "' at Line " + lineNumber + " is unrecognized";
		System.out.println(msg);
	}

	public static ArrayList<String> makeDictionaryFromFile(String fileName)
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
			reader.close();

		} catch (FileNotFoundException failedLookup){
			System.out.println("Failed to find the dictionary file.");
		}
		return contents;
	}

}	

/* INNER CLASSES BELOW */

class TSTNode 
{

	char c;
	boolean treeEnd;
	TSTNode leftChild, middleChild, rightChild;

	public TSTNode(char data)
	{
		this.c = data;
		this.treeEnd = false;
		this.leftChild = null;
		this.middleChild = null;
		this.rightChild = null;
	}
}

class TST 
{
	private TSTNode	root;

	// default constructor
	public TST()
	{
		root = null;
	}

	// encapsulation 
	public boolean contains(String word)
	{
		return contains(word, root, 0);			// mirroring TST implementation slide
	}

	private boolean contains(String word, TSTNode x, int pos)	// mirroring TST implementation slide
	{
		//base case
		if (x == null)
			return false;

		char c = word.charAt(pos);

		if (c < x.c) 
			return contains(word, x.leftChild, pos);		// less than case
		else if (c > x.c) 
			return contains(word, x.rightChild, pos);		// greater than case
		else if (pos < word.length()-1) 
			return contains(word, x.middleChild, pos+1);	// equality case
		else 
			return x.treeEnd;								// termination point
	}
	
	// encapsulation
	public void loadIntoTree(String word)
	{ 
		root = addToTree(root, word, 0); 
	}

	private TSTNode addToTree(TSTNode x, String word, int index)
	{
		char c = word.charAt(index);
		if (x == null) 
			x = new TSTNode(c);
		if (c < x.c) 
			x.leftChild = addToTree(x.leftChild, word, index);
		else if (c > x.c) 
			x.rightChild = addToTree(x.rightChild, word, index);
		else if (index < word.length()-1) 
			x.middleChild = 	addToTree(x.middleChild, word, index+1);
		else 
			x.treeEnd = true;
		return x;
	}

}

