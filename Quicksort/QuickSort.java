
import java.util.Arrays;
import static java.lang.System.*;

class QuickSort
{
	private static int passCount;

	private QuickSort()
	{
		passCount = 0;
	}

	public static void quickQuickSort(Comparable[] list )
	{
		passCount=0;
		quickSort(list, 0, list.length-1);
		System.out.println ("pass " + passCount+ " "+Arrays.toString(list));
	
	}

	private static void quickSort(Comparable[] intArray, int first, int last)
	{	
		if (first < last)
		{
				System.out.println ("pass " + passCount+ " "+Arrays.toString(intArray));
				passCount++;
			Comparable temp = 0;
   			Comparable pivotValue = intArray[first];
   			int pivotIndex = first;

   			for (int k = first+1; k <= last; k++)
   			{
      			if (intArray[k].compareTo(pivotValue)<1)
      			{
	 				pivotIndex++;
	 				temp = intArray[k];
	 				intArray[k] = intArray[pivotIndex];
	 				intArray[pivotIndex] = temp;
      			}
   			}
   			temp = intArray[pivotIndex];
   			intArray[pivotIndex] = intArray[first];
   			intArray[first] = temp;
   			
   			quickSort(intArray, first,pivotIndex-1);
      		quickSort(intArray, pivotIndex+1,last);
      	}
	
	}
}