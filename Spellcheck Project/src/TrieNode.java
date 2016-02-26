
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
