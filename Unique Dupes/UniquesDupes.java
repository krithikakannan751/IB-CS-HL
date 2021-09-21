
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;

public class UniquesDupes
{
	private ArrayList<String> list;


	/**
	 * constructs a UniquesDupes object such that list contains the space delimited strings
	 * parsed from input
	 * @param input a String containing the list of words separated by spaces
	 */
	public UniquesDupes(String input)
	{


	}
		
	/**
	 * returns a set of Strings containing each unique entry in the list
	 */
	public Set<String> getUniques()
	{
		Set<String> uniques = new TreeSet<String>();





		return uniques;
	}
	
	/**
	 * returns a set of Strings containing each entry in the list that occurs more than once
	 */
	public Set<String> getDupes()
	{
		Set<String> uniques = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();







		return dupes;
	}

	/**
	 * returns the original list, the list of duplicates and the list of uniques
	 * @return the String version of the object
	 */
	public String toString()
	{
		return "Orig list :: " + list
		      + "\nDuplicates :: " + getDupes()
		      + "\nUniques :: " + getUniques() + "\n\n";
	}
}