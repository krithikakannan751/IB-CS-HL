
//ListIterator previous example 1


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class PreviousOneTest
{
   public static void main(String args[])
	{
		ArrayList<String> words;
		words = new ArrayList<String>();

		words.add("Have");
		words.add("a");
		words.add("Great");
		words.add("break");

		//Iterator<String> it = words.listIterator();
		ListIterator<String> it = words.listIterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.previous());	
				//why is there a problem????

		//uncomment and watch the fireworks
		//System.out.println(it.previous());
		//System.out.println(it.previous());
	}
}
