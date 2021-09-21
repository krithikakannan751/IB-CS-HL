
//ArrayList of ints
//or
//array of ints

import static java.lang.System.*;
import java.util.ArrayList;


public class IntStack
{
	private ArrayList<Integer> listOfInts;

	
	public IntStack()
	{
		listOfInts = new ArrayList<Integer>();
	}
	
	public void push(int item)
	{
		listOfInts.add(item);
	}
	
	public int pop()
	{
		if(!isEmpty())
		return listOfInts.remove(listOfInts.size()-1);
		else throw new IndexOutOfBoundsException("error: no elements to pop");
	}
	
	public boolean isEmpty()
	{
		if(listOfInts.size()>0)
			return false;
		else return true;
	}
	
	public int peek()
	{
		if(!isEmpty())
		return listOfInts.get(listOfInts.size()-1);
		else throw new IndexOutOfBoundsException("error: no elements to peek");
	//	return 0;
	}
	
	public String toString()
	{
		return listOfInts.toString();
	}
}