
/**
 *A class to test the methods of the ProductList class
 */
 public class ProductListTester
{
	/** ******************************************************************************THIS IS SINGLE LINK
	 * Constructs a ProductList and tests its methods
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		ProductList list = new ProductList();
		System.out.println("Ms. Horton's Tester");
		
		System.out.println("SECTION 1:");
		System.out.println("Testing addFirst, addLast, size and find");
		list.addFirst(new Product("cheese",4.99,2));
		list.addFirst(new Product("pizza",5.52,1));
		list.addLast(new Product("milk",3.09,3));
		list.addFirst(new Product("chicken",7.23,1));
		
		System.out.println("List contains " + list.size() + " elements");
		System.out.println(list);
		System.out.println("Find chicken: " + list.find("chicken"));
		System.out.println("Find milk: " + list.find("milk"));
		System.out.println("Find yogurt: " + list.find("yogurt"));
		
		list.clear();
		
		System.out.println("\n\nSECTION 2:");
		System.out.println("Testing add, getFirst and getLast");
		list.add(new Product("spaghetti",1.95,2));
		list.add(new Product("apples",.65,5));
		list.add(new Product("tomato sauce",3.71,2));
		list.add(new Product("bananas",1.23,3));
		System.out.println("List contains " + list.size() + " elements");
		System.out.println(list);
		System.out.println("First product: " + list.getFirst());
		System.out.println("Last product: " + list.getLast());
		System.out.println(list);
		
		System.out.println("\n\nSECTION 3:");
		System.out.println("testing add(index)"); 
		System.out.println(list);
		list.add(0,new Product("pickles",2.50,1));
		list.add(5,new Product("ice cream",5.79,5)); 
		list.add(3,new Product("caramel sauce",3.15,2));
		
		System.out.println("List contains " + list.size() + " elements");
		System.out.println(list);
		try 
		{	
			System.out.println("Attempt to add at index 8");
			list.add(8,new Product("fail",1,1));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		System.out.println("\n\nSECTION 4:");
		System.out.println("Testing indexOf, remove(index)");
		System.out.println(list);
		System.out.println("Index of pickles: " + list.indexOf("pickles"));
		System.out.println("Index of bananas: " + list.indexOf("bananas")); 
		System.out.println("Index of ice cream: " + list.indexOf("ice cream"));
		System.out.println("Index of spam: " + list.indexOf("spam"));
		System.out.println("\nRemoving " + list.remove(0));
		System.out.println("Removing " + list.remove(2)); //remove no work
		
		System.out.println("Removing " + list.remove(4)); // no work, oh its fine, index decreases because values are removed
		System.out.println();
		try
		{
			System.out.println("Attempt to remove index 4");
			list.remove(4);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	//	System.out.println(list);
		//working fine to here************************************************************
		
		System.out.println("\n\nSECTION 5:");
		System.out.println("Testing set and remove(String)");
		System.out.println(list);
		list.set(0,new Product("pears",.75,4));
		list.set(3,new Product("alfredo sauce",4.26,2)); //no work
		list.set(1,new Product("mango",1.80,2)); //should be pear, mango, spaghetti, alfredo
		System.out.println(list); //mine
		try
		{
			System.out.println("Attempt to set at index 4");
			list.set(4,new Product("fail",1,1));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("\n" + list);
		
		System.out.println("Removing " + list.remove("pears"));
		System.out.println("Removing " + list.remove("alfredo sauce"));
		System.out.println("Attempt to remove candy: " + list.remove("candy"));
		System.out.println("Removing " + list.remove("mango"));
		System.out.println("Removing " + list.remove("spaghetti"));
		System.out.println("\nList is now empty");
	
	
	//	System.out.println(list);
		
		System.out.println("\n\nSECTION 6:");
		System.out.println("Testing operations on empty list\n");
		try
		{
			System.out.println("Attempt getFirst");
			System.out.println(list.getFirst());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();
		try
		{
			System.out.println("Attempt getLast");
			System.out.println(list.getLast());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("\nIndex of rice: " + list.indexOf("rice"));
		System.out.println("\nAdding to index 0");
		list.add(0,new Product("jello",.99,10));
		System.out.println(list);
		
		System.out.println("\nSUCCESS!!");
		
	}
	
}