

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class ListIteratorTest
{
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public ListIteratorTest(String line, String rem, String rep)
	{
		String[] words = line.split(" ");   
		list = new ArrayList<String>(Arrays.asList(words));
		toRemove = rem;
		replaceWith = rep; 
	}

	public void replace()
	{
		ListIterator<String> it = list.listIterator();
		while(it.hasNext())
		{
			if(it.next().equals(toRemove))
			{	
				it.set(replaceWith);
			}
		}
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}