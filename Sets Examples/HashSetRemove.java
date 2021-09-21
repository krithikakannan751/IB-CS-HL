
//hash set remove example

import java.util.Set;
import java.util.HashSet;

public class HashSetRemove
{
	public static void main(String args[])
	{
		Set<Double> doubleSet = new HashSet<Double>();
		doubleSet.add(2.5);
		doubleSet.add(5.8);
		doubleSet.add(7.3);
		System.out.println(doubleSet);
		System.out.println(doubleSet.remove(5.8));
		System.out.println(doubleSet.remove(0));
		System.out.println(doubleSet);
		
	}
}