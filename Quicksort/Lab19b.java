
import java.util.Arrays;
import static java.lang.System.*;

public class Lab19b
{
	public static void main( String args[] )
	{
		QuickSort.quickQuickSort(new Comparable[]{9,5,3,2});
		out.println("\n\n");

		QuickSort.quickQuickSort(new Comparable[]{19,52,3,2,7,21});
		out.println("\n\n");

		QuickSort.quickQuickSort(new Comparable[]{68,66,11,2,42,31});
		out.println("\n\n");
	}
}