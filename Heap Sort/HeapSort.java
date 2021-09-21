

public class HeapSort
{
	/**
	 * receives an integer array, uses a Heap object to perform a heap sort on the array 
	 * resulting in an ascending sort of the array.
	 * @param nums the integer array to sort
	 */

	public static void sort(int[] list)
	{
		int k,t;
	int n = list.length;
	for (k = (n-1)/2; k >= 0; k--)
            fixHeap(list,k,n-1);
	for (k = n-1; k >= 0; k--)
  	{
		t = list[0];
            	list[0] = list[k];
            	list[k] = t;
            	fixHeap(list,0,k-1);
   	}
	}
	public static void fixHeap(int [] list, int top, int bottom)
	{
	int k,t;
	k = top * 2;
   	if (k <= bottom) 
   	{
		if (k < bottom)
			if (list[k] < list[k+1])  
				k++;
		if (list[top] < list[k]) {
    			t = list[top];  list[top] = list[k];   list[k] = t;
			fixHeap(list,k,bottom);
 		}
	}
	}


}