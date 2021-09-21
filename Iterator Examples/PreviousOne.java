
//ListIterator previous example 1


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class PreviousOne
{
   public static void main(String args[])
	{
		ArrayList<String> words;
		words = new ArrayList<String>();

		words.add("at");
		words.add("is");
		words.add("of");
		words.add("boom");

		//Iterator<String> it = words.listIterator();
		ListIterator<String> it = words.listIterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.previous());		//why is there a problem????
		System.out.println(it.next());
		//uncomment and watch the fireworks
	//System.out.println(it.previous());
		//System.out.println(it.previous());
	}
}
