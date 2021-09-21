

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class Lab03b
{
	public static void main ( String[] args )
	{
		//add test cases	
		String words = "a b c a b c a";
		ListIteratorTest red = new ListIteratorTest(words, "a", "+");
		System.out.println(red.toString());
		red.replace();
		System.out.println(red.toString());  
			 
		String words1 = "a b c d e f g h i j x x x x";
		ListIteratorTest red1 = new ListIteratorTest(words1, "x", "7");
		System.out.println(red1.toString());
		red1.replace();
		System.out.println(red1.toString());  
			 
		String words2 = "1 2 3 4 5 6 a b c a b c";
		ListIteratorTest red2 = new ListIteratorTest(words2, "b", "#");
		System.out.println(red2.toString());
		red2.replace();
		System.out.println(red2.toString()); 
	}
}