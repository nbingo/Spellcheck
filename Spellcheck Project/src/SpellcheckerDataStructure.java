/**
 * An interface for the data structures that can be used in Spellchecker so that they all
 * have the same basic methods.
 * @author Nomi
 * @since 2.22.16
 * @see WordTrie
 * @version 1.0.0
 */
public interface SpellcheckerDataStructure 
{
	public boolean add      (String word);
	public boolean remove   (String word);
	public boolean contains (String word);
	public boolean isEmpty  ();
	public int     Size     ();
}
