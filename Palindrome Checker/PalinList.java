
import java.util.*;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;
	private ArrayList<String> print;

	public PalinList()
	{
		setList("");
	}

	public PalinList(String list)
	{

		queue = new LinkedList<String>();
		stack = new Stack<String>();
		print = new ArrayList<String>();
		setList(list);
	}

	public void setList(String list)
	{
	
		String[] str = list.split(" ");
		queue.clear();
		stack.clear();
		print.clear();
		for(String s: str)
		{
			queue.add(s);
			stack.add(s);
			print.add(s);
		}
	}

	public boolean isPalin()
	{
		while(!queue.isEmpty() && !stack.isEmpty())
		{
			
			if(queue.remove().equals(stack.pop()))
				return true;
		}
		return false;
	}

	
	//write a toString method
	public String toString()
	{
		String s = "";
		if(!isPalin())
			s = "not ";
		return print + " is " + s + " a palinlist.";
	}
}
