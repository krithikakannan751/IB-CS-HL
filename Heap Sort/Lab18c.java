

import java.util.*;

public class Lab18c 
{
	public static void main ( String[] args )
	{
		int[] nums = {99,2,8,75,10,7,9,17,5,3,4,1,11,1};
		
		HeapSort.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		int[] stuff = {-3,28,18,5,3,17,29,6,5,3,4,1,11,1};
		
		HeapSort.sort(stuff);
		
		System.out.println(Arrays.toString(stuff));
	}
}