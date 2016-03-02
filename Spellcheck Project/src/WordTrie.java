
/**
 * A trie data structure modified specifically to hold words in the alphabet with only lowercase letters.
 * It uses {@link TrieNode Trie Nodes} to hold the dictionary.
 * @author Nomi
 * @since 2.22.16
 * @see SpellcheckerDataStructure
 * @see TrieNode
 */
public class WordTrie implements SpellcheckerDataStructure
{
	private TrieNode root;
	private int      size;    //how many words are in it
	
	public WordTrie()
	{
		root = new TrieNode();
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int Size()
	{
		return size;
	}
	
	public boolean contains(String word)
	{
		if (word.length() == 0 || containsNum(word))
			return true;
		else if (!root.containsLetter(charToInt(word.charAt(0))))  //if the trie doesn't contain the first letter of the word
			return false;
		else
			return contains(word, root.getNode(charToInt(word.charAt(0))), 1);
	}
	
	public boolean add(String word) //not complete yet
	{
		if (contains(word))
			return false;
		int firstLetterNum = charToInt(word.charAt(0));
		if (root.getNode(firstLetterNum) == null)
			root.setNode(firstLetterNum, new TrieNode());
		add(word, root.getNode(firstLetterNum), 1);
		size++;
		return true;
	}
	
	public boolean add(String... words)
	{
		boolean added = true;
		for (String s : words)
			added &= add(s);
		return added;
	}
	
	public boolean remove(String word) //not complete yet
	{
		if (!contains(word))
			return false;
		size--;
		return true;
	}
	
	private int charToInt(char c)
	{
		if(c == '\'') //apostrophes are just the last part of the array of size 27
			return 26;
		else if (c == '-' || c == ',')
			return 27;
		else
			return c - 97;
	}
	
	private boolean contains(String word, TrieNode node, int currentLetter)
	{
		if (currentLetter >= word.length()-1)	 //if we're at the end of the word then check if we can end on this node
			return node.isEnd();
		TrieNode nextNode = node.getNode(charToInt(word.charAt(currentLetter))); //the node or null value at the value for that letter in the array of the current node
		if (currentLetter < word.length()-1 && nextNode != null)				 //if we're still not at the end of the word and the node has the next letter
			return contains(word, nextNode, currentLetter+1);						
		return false;
	}
	
	private boolean containsNum(String word)
	{
		for (char c : word.toCharArray())
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '-')
				return true;
		return false;
	}
	
	private void add(String word, TrieNode node, int currentLetter)
	{
		if (currentLetter >= word.length()-1)							//we're at the end of the word, so we end the word
			node.setEnd(true);
		else
		{
			int letterNum = charToInt(word.charAt(currentLetter));
			if (node.getNode(letterNum) != null)					//the current node does contain the next letter
				add(word, node.getNode(letterNum), currentLetter+1);
			else													//the current node doesn't contain the next letter
			{
				node.setNode(letterNum, new TrieNode());	        //put a TrieNode there so we're adding the letter
				add(word, node.getNode(letterNum), currentLetter+1);
			}
		}
	}
}
