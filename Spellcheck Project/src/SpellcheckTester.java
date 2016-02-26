import java.io.*;

public class SpellcheckTester {
	public static void main(String args[]) throws IOException, FileNotFoundException
	{
		//Data Structure 1
		System.out.println("Using data structure 1");
		Runtime runtime = Runtime.getRuntime();
		long startMemory = runtime.freeMemory();
		long startTime = System.currentTimeMillis();
		Spellchecker sc;
		try {
			sc = new Spellchecker("dictionary.txt", true);
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary is not in the right place; should not be in src folder.");
			return;
		}
		long postInitTime = System.currentTimeMillis();
		long endMemory = runtime.freeMemory();
		long bytesUsed = startMemory - endMemory;
		String usedString;
		if (bytesUsed < 1000)
			usedString = bytesUsed + " bytes";
		else if (bytesUsed < 1000000)
		{
			double kbUsed = ((double) bytesUsed)/1000.0;
			usedString = kbUsed + " KB";
		}
		else
		{
			double mbUsed = ((double) bytesUsed)/1000000.0;
			usedString = mbUsed + " MB";
		}
		System.out.println("Total memory used for the dictionary: " + usedString);
		try {
			sc.findErrors("big.txt", "errors1.txt", true);
		} catch (FileNotFoundException e) {
			System.out.println("The big.txt is not in the right place; should not be in src folder.");
		}
		long postFindTime = System.currentTimeMillis();

		System.out.println("Total time used was " + (postFindTime - startTime) + " milliseconds.");
		System.out.println((postInitTime - startTime) + " milliseconds were used in preprocessing");
		System.out.println((postFindTime - postInitTime) + " milliseconds were used to find the errors");

		//Data Structure 2
		System.out.println("Using data structure 2");
		sc = null;
		startMemory = runtime.freeMemory();
		startTime = System.currentTimeMillis();
		try {
			sc = new Spellchecker("dictionary.txt", false);
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary is not in the right place; should not be in src folder.");
			return;
		}
		postInitTime = System.currentTimeMillis();
		endMemory = runtime.freeMemory();
		bytesUsed = startMemory - endMemory;
		if (bytesUsed < 1000)
			usedString = bytesUsed + " bytes";
		else if (bytesUsed < 1000000)
		{
			double kbUsed = ((double) bytesUsed)/1000.0;
			usedString = kbUsed + " KB";
		}
		else
		{
			double mbUsed = ((double) bytesUsed)/1000000.0;
			usedString = mbUsed + " MB";
		}
		System.out.println("Total memory used for the dictionary: " + usedString);
		try {
			sc.findErrors("big.txt", "errors2.txt", false);
		} catch (FileNotFoundException e) {
			System.out.println("The big.txt is not in the right place; should not be in src folder.");
		}
		postFindTime = System.currentTimeMillis();

		System.out.println("Total time used was " + (postFindTime - startTime) + " milliseconds.");
		System.out.println((postInitTime - startTime) + " milliseconds were used in preprocessing");
		System.out.println((postFindTime - postInitTime) + " milliseconds were used to find the errors");
	}

}
