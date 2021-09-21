

import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
	private ArrayList<Integer> list;

	/**
	 * Instantiates the heap with an empty list
	 */
	public Heap()
	{
		list = new ArrayList<Integer>();
	}

	/**
	 * adds value to the heap
	 * @param value the value to add
	 */
	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

	/**
	 * swapUp is called by add to restructure the tree so that a newly added item is in the proper
	 * location in the heap.   swapUp first checks to see if the new item is bigger than its parent.
	 * If it is, swapUp swaps the parent and the new item and repeats the same process until the new
	 * item is in the root position or it finds that the new item is not larger than its current 
	 * parent.
	 * @param bot the index of the newly added item
	 */
   public void swapUp(int bot)
   {
		if(bot >0)
		{
			if(bot%2 == 1 && list.get((bot-1)/2) < list.get(bot))
			{
			//	System.out.println ("left child");
				swap(bot, (bot-1)/2);
				swapUp((bot-1)/2);
			}
			else if(list.get((bot-2)/2) < list.get(bot))
			{	
			//	System.out.println ("right child");
				swap(bot, (bot-2)/2);
				swapUp((bot-2)/2);
			}
		}
	//	else System.out.println ("root");
	}

	/**
	 * Remove copies the root to a variable and then moves the last value in the 
	 * tree to the root-array spot 0.   Remove then calls swapDown to restructure the tree.
	 */
	public int remove( )
	{
		int top = list.get(0);
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(0);
		return top;
	}

	/**
	 * swapDown is called by remove to restructure the tree. 
	 * swapDown looks at the children of the new root and determines which is larger.   
	 * The larger of the children and the new root are then swapped.   This process continues 
	 * until the bottom of the tree is reached or there are no children larger than the current 
	 * parent.
	 */
	public void swapDown(int top)
	{
		if(top*2+2<list.size()) //have two children
		{
			if(list.get(top*2+1)>list.get(top*2+2)) //left big
			{
				if(list.get(top*2+1)>list.get(top))
				{	
					swap(top, top*2+1);
					swapDown(top*2+1);
				}	
			}
			else //right big
			{
				if(list.get(top*2+2)>list.get(top))
				{	
					swap(top, top*2+2);
					swapDown(top*2+2);
				}	
		
			}
		}
		else if(top*2+1<list.size()) //have one child
		{
			if(list.get(top*2+1)>list.get(top))
				{	
					swap(top, top*2+1);
					swapDown(top*2+1);
				}	
		
		}
	
	}
	
	/**
	 * swaps the elements of the tree at indexes start and finish
	 * @param start the first index
	 * @param finish the last index
	 */
	private void swap(int start, int finish)
	{
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	/** 
	 * prints the heap in the form of a tree structure
	 */
	public void print()
	{
		System.out.println ("PRINTING THE HEAP!\n");
		if(list.size()!= 0)
		{
		String[] arr = new String[list.size()];
		for(int co = 0; co<list.size();co++)
			arr[co] = Integer.toString(list.get(co));
		ArrayList<String> aListLevel = new ArrayList<String>();
		
		//get the root printed
		aListLevel.add(arr[0]);
		System.out.print (centerStrings(aListLevel)+ "\n");
		aListLevel.clear();
		int level = 1;
		for(int i = 1; i<arr.length; i++)
		{
			if(Math.pow(2, level) == aListLevel.size()) //if needs to be on new line (is to the left)
			{
				System.out.print( centerStrings(aListLevel)+"\n");
				aListLevel.clear();
				level++;
			//	count = 0;
			}
			aListLevel.add(arr[i]);
		//	count++;
	//		System.out.println(i);
		}
		System.out.println (centerStrings(aListLevel));
		}
	}
	public String centerStrings(ArrayList<String> sList)
	{
		String[] arr = inOrderString(0).split(" ");
		for(int i = 0; i<arr.length; i++)
		{
			if(sList.indexOf(arr[i]) == -1)
			{
				//	arr[i] = "  ";
				String space = "";
				for(int spaceL = 0; spaceL<arr[i].length(); spaceL++)
				{
					space+= " ";
				}
				arr[i] = space;
			}
		}
		String sRet = "";
		for(String sAdd: arr)
		{
			sRet += sAdd;
		}
		return sRet;
	}
	public String inOrderString(int ind)
	{
		String s = "";
		if (ind>-1 && ind<list.size())
		{
			s+= inOrderString(ind*2+1);
			s+= list.get(ind) + " ";
			s+=	inOrderString(ind*2+2);
		}
		return s;

	}
	/**
	 * returns the string version of the list
	 * @return the string version of the list
	 */
	public String toString()
	{
		return list.toString();
	}
}