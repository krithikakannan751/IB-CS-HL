
import java.util.ArrayList;
import static java.lang.System.*;
import java.io.*;

public class Lab13d
{
	public static void main ( String[] args ) throws IOException
	{
		IntStack test = new IntStack();
		test.push(7);
		test.push(5);
		test.push(9);
		System.out.println(test);
		System.out.println(test.isEmpty());
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.isEmpty());
		System.out.println(test);
		
				

		//to get a 100, you must expand the test cases to test the class more thoroughly
		test.push(9);
		test.push(2);
		test.push(-1);
		test.push(23);
		test.push(1);
		test.push(123);
		test.push(21);
		test.push(4);
		test.push(4);
		System.out.println(test);
		System.out.println(test.isEmpty());
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.isEmpty());
		System.out.println(test.pop());
		System.out.println(test.pop());System.out.println(test.pop());
		System.out.println(test.pop());System.out.println(test.pop());
		System.out.println(test.pop());
	
		System.out.println(test);		
		
		
		try{
		
		System.out.println(test.pop());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		try{
		
		System.out.println(test.peek());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}