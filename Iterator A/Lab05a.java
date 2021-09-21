
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.*;

public class Lab05a
{
	public static void main ( String[] args )
	{
		String words = "a b c a b c a";
		IteratorTest red = new IteratorTest(words, "a");
		System.out.println(red.toString());
		red.remove();
		System.out.println(red.toString());  
			 
		String words1 = "a b c d e f g h i j x x x x";
		IteratorTest red1 = new IteratorTest(words1, "x");
		System.out.println(red1.toString());
		red1.remove();
		System.out.println(red1.toString());  
			 
		String words2 = "1 2 3 4 5 6 a b c a b c";
		IteratorTest red2 = new IteratorTest(words2, "b");
		System.out.println(red2.toString());
		red2.remove();
		System.out.println(red2.toString());   
			
	}
}