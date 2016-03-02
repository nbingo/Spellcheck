import java.io.*;
import java.util.*;

public class Spellchecker {
	
	private WordTrie myDictionary;
//	private Hashtable<Integer, String> myHashtable;
	private ArrayList<String> myList;
	//Creates a Spellchecker based on a dictionary given at creation.  dictionaryFileName is the name
	// of the file where the dictionary is to be found.  We may assume the dictionary is a big list
	// of words.
	public Spellchecker(String dictionaryFileName, boolean ds1) throws FileNotFoundException, IOException
	{
		Scanner scan = new Scanner(new BufferedReader(new FileReader(dictionaryFileName)));
		scan.useDelimiter("[^a-zA-Z]*[^a-zA-Z']+[^a-zA-Z]*");
		if (ds1) //we're going to use a Trie
		{
			myDictionary = new WordTrie();
			while (scan.hasNext())
				myDictionary.add(scan.next().toLowerCase(Locale.ENGLISH));
		}
		else
		{
			myList = new ArrayList<String>(115007);
			while (scan.hasNext())
				myList.add(scan.next().toLowerCase(Locale.ENGLISH));
		}
		scan.close();
	}

	// Searches the file given by textFileName for all spelling errors, and outputs
	// every word in that file that's not found in the dictionary to the file given by
	// outputFileName.
	// Don't forget to make every word lower case before checking it.
	public void findErrors (String textFileName, String outputFileName, boolean ds1) throws FileNotFoundException, IOException
	{
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
		Scanner     scan  = new Scanner (new BufferedReader(new FileReader(textFileName)));
		scan.useDelimiter("[^a-zA-Z]*[^a-zA-Z']+[^a-zA-Z]*");
		if(ds1)
			while (scan.hasNext())
			{
				String word = scan.next().toLowerCase(Locale.ENGLISH);
				if (!myDictionary.contains(word))
					write.println(word);
			}
		else
			while (scan.hasNext())
			{
				String word = scan.next().toLowerCase(Locale.ENGLISH);
				if (Collections.binarySearch(myList, word) < 0)
					write.println(word);
			}
		
		write.close();
		scan.close();
	}
}
