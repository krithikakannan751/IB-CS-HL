
public class Lab14atst
{
	public static void main ( String[] args )
	{
		
		String data = "one two three two one";
		PalinList test = new PalinList(data);
		System.out.println (test);
		
		data = "1 2 3 4 5 one two three four five";
		test.setList(data);
		test.toString();
		
		data = "a b c d e f g x y z g f h";
		test.setList(data);
		test.toString();
		
		data = "racecar is racecar";
		test.setList(data);
		test.toString();
		
		data = "1 2 3 a b c c b a 3 2 1";
		test.setList(data);
		test.toString();
		
		data = "chicken is a chicken";
		test.setList(data);
		test.toString();
		
		data = "racecar $ $ racecar";
		test.setList(data);
		test.toString();
		System.out.println ("END\n");		
	}
}
