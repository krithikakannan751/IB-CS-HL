
//tree set int example

import java.util.Set;
import java.util.TreeSet;

public class TreeSetInt
{
	public static void main(String args[])
	{
		Set<Integer> intSet;
		intSet = new TreeSet<Integer>();
		System.out.println(intSet.add(45));
		intSet.add(12);
		System.out.println(intSet.add(12));
		intSet.add(23);
		intSet.remove(23);
		System.out.println(intSet);
		System.out.println (intSet.add(23));
		System.out.println(intSet);
	}
}