/**
 * A simple Trie Node that has been modified to work with the {@link WordTrie} class and hold words in it,
 * including apostrophes and periods (by using a boolean value).
 * @author Nomi
 * @since 2.28.16
 * @version 1.0.0
 * @see WordTrie
 */
public class TrieNode 
{
	private final static int DEFAULT_LENGTH = 28;
	
	private boolean isEnd;
	private TrieNode[] alphabet;
	
	public TrieNode(boolean end, int length)
	{
		isEnd = end;
		alphabet = new TrieNode[length];
	}
	public TrieNode(boolean end)
	{
		this(end, DEFAULT_LENGTH);
	}
	
	public TrieNode()
	{
		this(false);
	}
	
	public boolean isEnd()
	{
		return isEnd;
	}
	
	public void setEnd(boolean end)
	{
		isEnd = end;
	}
	
	public void setNode(int letter, TrieNode node)
	{
		alphabet[letter] = node;
	}
	
	public TrieNode getNode(int letter)
	{
		return alphabet[letter];
	}
	
	public TrieNode[] getArray()
	{
		return alphabet;
	}
	
	public boolean containsLetter(int letter)
	{
		return alphabet[letter] != null;
	}
}
