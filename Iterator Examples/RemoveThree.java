
//Iterator remove example


import java.util.ArrayList;
import java.util.Iterator;

public class RemoveThree
{
   public static void main(String args[])
	{
	ArrayList<Double> rList = new ArrayList<Double>();
rList.add(4.0);
rList.add(3.5);
rList.add(5.67);
rList.add(23.0);
rList.add(215.45);
Iterator<Double> itah = rList.iterator();
while(itah.hasNext()){
   itah.next();
   itah.remove();
   
}
System.out.println(rList);

	}
}
